package sgf.properties;

import sgf.MoveProperty;
import sgf.types.ValueType;
import sgf.types.ValueTypes;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 9 déc. 2007
 * Time: 13:33:15
 * To change this template use File | Settings | File Templates.
 */
public class MN extends MoveProperty {

    private int number = 0;

    public ValueType getValueType() {
        return ValueTypes.NUMBER;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1) return false;
        try {
            number = Integer.parseInt(value.get(0));
            return true;
        } catch(NumberFormatException nfe) {
            return false;
        }
    }

    public Object getSGFValue() {
        return number;
    }

    public int getMoveNumber() {
        return number;
    }
}
