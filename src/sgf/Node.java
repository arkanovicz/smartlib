package sgf;

import sgf.types.ValueType;

import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Collection;
import java.io.PrintWriter;

import util.Logger;

public class Node {

    protected LinkedList<Node> children = null;
    protected Map<String,Property> properties = new TreeMap<String,Property>();

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

    public int getChildrenCount() {
        return children == null ? 0 : children.size();
    }

  public Node getChild(int index)
  {
    return children.get(index);
  }
  
}
