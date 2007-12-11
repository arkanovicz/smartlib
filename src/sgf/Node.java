package sgf;

import sgf.types.ValueType;

import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class Node {

    LinkedList<Node> children = null;
    Map<String,Property> properties = new TreeMap<String,Property>();

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
        result.append(';');
        for(Property property:properties.values()) {
            result.append(property.toString());
        }
        if(children != null) {
            result.append('(');
            for(Node child:children) {
                result.append(child.toString());
            }
            result.append(')');
        }
        return result.toString();
    }
}
