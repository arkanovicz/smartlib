package sgf.properties;

import sgf.InfoProperty;
import sgf.types.ValueType;
import sgf.types.ValueTypes;
import sgf.types.SimpleText;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 10 déc. 2007
 * Time: 16:39:28
 * To change this template use File | Settings | File Templates.
 */
public class EV extends InfoProperty {

    private String event = null;

    public ValueType getValueType() {
        return ValueTypes.SIMPLE_TEXT;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1) return false;
        event = SimpleText.unescape(value.get(0));
        return true;
    }

    public Object getSGFValue() {
        return SimpleText.escape(event);
    }

    public String getEvent() {
        return event;
    }
}
