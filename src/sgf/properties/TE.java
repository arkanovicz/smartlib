package sgf.properties;

import sgf.MoveProperty;
import sgf.types.ValueType;
import sgf.types.ValueTypes;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 10 déc. 2007
 * Time: 12:53:47
 * To change this template use File | Settings | File Templates.
 */
public class TE extends MoveProperty {

    private int emphasis = 0;

    public ValueType getValueType() {
        return ValueTypes.DOUBLE;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1) return false;
        try {
            emphasis = Integer.parseInt(value.get(0));
            return true;
        } catch(NumberFormatException nfe) {
            return false;
        }
    }

    public Object getSGFValue() {
        return emphasis;
    }

    public int getEmphasis() {
        return emphasis;
    }
}
