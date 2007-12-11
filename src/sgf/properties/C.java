package sgf.properties;

import sgf.Property;
import sgf.types.ValueType;
import sgf.types.ValueTypes;
import sgf.types.Text;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 10 déc. 2007
 * Time: 12:44:24
 * To change this template use File | Settings | File Templates.
 */
public class C extends Property {

    private String text = null;

    public ValueType getValueType() {
        return ValueTypes.TEXT;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1) return false;
        text = Text.unescape(value.get(0));
        return true;
    }

    public Object getSGFValue() {
        return Text.escape(text);
    }

    public String getText() {
        return text;
    }
}
