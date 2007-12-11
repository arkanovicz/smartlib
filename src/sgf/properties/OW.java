package sgf.properties;

import sgf.MoveProperty;
import sgf.types.ValueType;
import sgf.types.ValueTypes;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 10 déc. 2007
 * Time: 16:56:33
 * To change this template use File | Settings | File Templates.
 */
public class OW extends MoveProperty {

    int moves = 0;

    public ValueType getValueType() {
        return ValueTypes.NUMBER;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1) return false;
        try {
            moves = Integer.parseInt(value.get(0));
            return true;
        } catch(NumberFormatException nfe) {
            return false;
        }
    }

    public Object getSGFValue() {
        return moves;
    }

    public int getMovesLeft() {
        return moves;
    }
}
