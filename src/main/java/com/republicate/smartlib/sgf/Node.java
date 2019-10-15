package com.republicate.smartlib.sgf;

import com.republicate.smartlib.sgf.types.ValueType;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.io.PrintWriter;

import com.republicate.smartlib.util.Logger;

public class Node {

    protected LinkedList<Node> children = null;
    protected Map<String,Property> properties = new TreeMap<String,Property>();

  // TODO - all those properties cannot be cached if the tree is updated
    protected int branchDepth = -1;
    protected int yOffset = -1;
    protected int linearDepth = -1;

//    private PropertyType nodeType = PropertyType.none;

    /**
     * empty node
     */
    public Node()
    {
    }

    public void addChild(Node node) {
        if(children == null)
        {
            children = new LinkedList<Node>();
        }
        children.add(node);
        node.setParent(this);
    }

    private Node parent = null;

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }

    public void addProperty(Property property)
    {
        properties.put(property.getId(),property);
    }

    public ValueType getValueType() {
        return null;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        if(getParent() == null) {
            result.append('(');
        }
        result.append(';');
        for(Property property:properties.values()) {
            result.append(property.toString());
        }
        if(children != null) {
            if(children.size() == 1) {
                result.append(children.get(0).toString());
            } else {
                for(Node child:children) {
                    result.append('(');
                    result.append(child.toString());
                    result.append(')');
                }
            }
        }
        if(getParent() == null) {
            result.append(')');
        }
        return result.toString();
    }

    // TODO limiter la récursion, par ex chaîner pour un seul enfant
    public void walkTree(NodeIntrospector introspector) throws IntrospectionException {
        introspector.introspect(this);
        if(children != null && children.size() > 0) {
            for(Node child:children) {
                introspector.down(this);
                child.walkTree(introspector);
                introspector.up(this);
            }
        }
    }

    public void walkTree(NodeIntrospector introspector,PrintWriter logger) throws IntrospectionException {
        if(logger == null) {
            walkTree(introspector);
            return;
        }
        introspector.introspect(this);
        if(children != null && children.size() > 0) {
            for(Node child:children) {
                introspector.down(this);
                try {
                    child.walkTree(introspector,logger);
                } catch(IntrospectionException ie) {
                    logger.println("child node truncated: "+ie.getClass().getName()+": "+ie.getMessage());
Logger.error(ie.getMessage());
Logger.log(ie);
                    Throwable t = ie.getCause();
                    while (t != null) {
                        logger.println("Caused by: "+t.getClass().getName()+": "+t.getMessage());
                        t = t.getCause();
                    }
                }
                introspector.up(this);
            }
        }
    }

    public boolean hasProperty(String propId) {
        return properties.containsKey(propId);
    }

    public Property getProperty(String propId) {
        return properties.get(propId);
    }

/*
    public  void postParse() {
        // determines the type of the node...
        for(Property property:properties.values()) {
            if(property instanceof SetupProperty) {
                if(nodeType != PropertyType.none && nodeType != PropertyType.setup) {
                    Logger.warn("invalid SGF: mixing property types...");
                }
                nodeType = PropertyType.setup;
            } else if (property instanceof RootProperty) {
                if(nodeType != PropertyType.none && nodeType != PropertyType.root) {
                    Logger.warn("invalid SGF: mixing property types...");
                }
                nodeType = PropertyType.root;
            } else if (property instanceof MoveProperty) {
                if(nodeType != PropertyType.none && nodeType != PropertyType.move) {
                    Logger.warn("invalid SGF: mixing property types...");
                }
                nodeType = PropertyType.move;
            }
        }
    }

    public PropertyType getNodeType() {
        return nodeType;
    }
*/

    public Collection<Property> getProperties() {
        return properties.values();
    }

    public Map<String,Property> getPropertyMap() {
        return properties;
    }

    public int getChildrenCount() {
        return children == null ? 0 : children.size();
    }

    public List<Node> getChildren() {
        return children;
    }

    public Node getChild(int index)
    {
      return children.get(index);
    }

    public int getBranchDepth()
    {
      if(branchDepth == -1)
      {
        if(children == null) return 1;
        Node n = this;
        Deque<Integer> stack = new LinkedList<Integer>();
        boolean movingDown = true;
        while(true)
        {
          if(movingDown)
          {
            if(n.getChildrenCount() > 0)
            {
              stack.addLast(0);
              n = n.getChild(0);
            }
            else
            {
              n.branchDepth = 1;
              movingDown = false;
            }
          }
          else
          {
            int childDepth = n.branchDepth;
            n = n.getParent();
            n.branchDepth = Math.max(n.branchDepth, childDepth + 1);
            int children = n.getChildrenCount();
            int child = stack.removeLast() + 1;
            if(child == children)
            {
              if(n == this) break;
            }
            else
            {
              stack.addLast(child);
              n = n.getChild(child);
              movingDown = true;
            }
          }
        }
      }
      return branchDepth;
    }
  
    public int getYOffset()
    {
      if(yOffset == -1)
      {
        if(children == null) return 0;
        Node n = this;
        Node stopNode = getParent(); // may be null
        Deque<Integer> stack = new LinkedList<Integer>();
        boolean movingDown = true;
        List<Integer> offsets = new ArrayList<Integer>();
        int depth = 0;
        int currentOffset = 0;
        while(true)
        {
          if(movingDown)
          {
            if(offsets.size() < depth + 1) offsets.add(currentOffset);
            else
            {
              int previousOffset = offsets.get(depth);
              currentOffset = Math.max(currentOffset,previousOffset + 1);
              offsets.set(depth,currentOffset);
            }
            if(n.getChildrenCount() > 0)
            {
              stack.addLast(0);
              n = n.getChild(0);
              depth++;
            }
            else
            {
              n.branchDepth = 1;
              movingDown = false;
            }
          }
          else
          {
            n.yOffset = currentOffset;
            n = n.getParent();
            depth--;
            if(n == stopNode) break;
            int children = n.getChildrenCount();
            int child = stack.removeLast() + 1;
            if(child == children)
            {
              currentOffset = n.getChild(0).yOffset;
              if(currentOffset > offsets.get(depth)) offsets.set(depth,currentOffset);
            }
            else
            {
              stack.addLast(child);
              n = n.getChild(child);
              depth++;
              currentOffset += 1;
              movingDown = true;
            }
          }
        }
      }
      return yOffset;
    }

  public int getLinearDepth()
  {
    if(linearDepth == -1)
    {
      Node n = this;
      int ld = 1;
      while(n.getChildrenCount() > 0)
      {
        n = n.getChild(0);
        ld ++;
      }
      linearDepth = ld;
      ld = 1;
      while(n != this)
      {
        n.linearDepth = ld;
        n = n.getParent();
        ld++;
      }
    }
    return linearDepth;
  }

}
