package sgf.properties;

import sgf.Property;
import sgf.types.ValueType;
import sgf.types.ValueTypes;
import sgf.types.SimpleText;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 10 déc. 2007
 * Time: 12:44:24
 * To change this template use File | Settings | File Templates.
 */
public class N extends Property {

    private String name = null;

    public ValueType getValueType() {
        return ValueTypes.SIMPLE_TEXT;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1) return false;
        name = SimpleText.unescape(value.get(0));
        return true;
    }

    public Object getSGFValue() {
        return SimpleText.escape(name);
    }

    public String getName() {
        return name;
    }
}
