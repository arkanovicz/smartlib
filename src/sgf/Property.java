package sgf;

import sgf.types.ValueType;

import java.util.List;

import util.Logger;

/**
 */
public abstract class Property {
    protected String id;

    public static Property getInstance(String id, GameType gameType) {
        try {
            id = id.toUpperCase();
            String gm = gameType.toString().toLowerCase();
            /* first try including the game nodeType */
            Class clazz = null;
            try {
                clazz = Class.forName("sgf.properties."+gm+"."+id);
            } catch(ClassNotFoundException cnfe) {
                /* second try without hte game nodeType */
                clazz = Class.forName("sgf.properties."+id);
            }
            return (Property)clazz.newInstance();
        } catch(ClassNotFoundException cnfe) {
// parent will log this one            
//            SGFParser.warn("sgf parser: unknown property: "+id);
            return null;
        } catch(Exception e) {
            SGFParser.warn("sgf parser: problem instanciating property "+id+":");
            Logger.log(e);
            return null;
        }
    }

    public Property() {
        String clazz = getClass().getName();
        id = clazz.substring(clazz.lastIndexOf('.')+1);
    }

    public String getId() {
        return id;
    }

    public abstract PropertyType getPropertyType();

    public abstract ValueType getValueType();

    public abstract boolean addValue(List<String> value);

    public int removeValue(List<String> value)
    {
        return -1;
    }
    
    public abstract boolean doesPersist();

    public Object getSGFValue() {
        return null;
    }

    public String toString() {
        String clazz = getClass().getName();
        Object value = getSGFValue();
        return clazz.substring(clazz.lastIndexOf('.')+1) + "["+(value==null?"":value.toString())+"]";
    }
}
