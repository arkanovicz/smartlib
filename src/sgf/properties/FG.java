package sgf.properties;

import sgf.Property;
import sgf.types.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 10 déc. 2007
 * Time: 17:01:35
 * To change this template use File | Settings | File Templates.
 */
public class FG extends Property {

    private static ValueType valueType = new Or<None, Compose<sgf.types.Number, ComposedSimpleText>>(ValueTypes.NONE,new Compose<sgf.types.Number, ComposedSimpleText>(ValueTypes.NUMBER,ValueTypes.COMPOSED_SIMPLE_TEXT));

    private int flags = 0;
    private String name = null;

    public ValueType getValueType() {
        return valueType;
    }

    public boolean addValue(List<String> value) {
        if(value.size() > 0) {
            if(value.size() != 2) return false;
            try {
                flags = Integer.parseInt(value.get(0));
            } catch(NumberFormatException nfe) {
                return false;
            }
            name = ComposedSimpleText.unescape(value.get(1));
        }
        return true;
    }

    public Object getSGFValue() {
        return name == null ? "" : String.valueOf(flags)+":"+ComposedSimpleText.escape(name);
    }

    public int getFlags() {
        return flags;
    }

    public String getName() {
        return name;
    }
}
