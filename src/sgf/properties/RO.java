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
public class RO extends InfoProperty {

    private String round = null;

    public ValueType getValueType() {
        return ValueTypes.SIMPLE_TEXT;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1) return false;
        round = SimpleText.unescape(value.get(0));
        return true;
    }

    public Object getSGFValue() {
        return SimpleText.escape(round);
    }

    public String getRound() {
        return round;
    }
}
