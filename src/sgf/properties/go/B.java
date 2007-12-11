package sgf.properties.go;

import sgf.types.ValueType;
import sgf.types.go.GoValueTypes;
import sgf.types.go.Move;

import java.util.List;

import util.GoUtils;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 9 déc. 2007
 * Time: 12:17:15
 * To change this template use File | Settings | File Templates.
 */
public class B extends sgf.properties.B {

    private Move move = null;

    public ValueType getValueType() {
        return GoValueTypes.MOVE;
    }

    public boolean addValue(List<String> value) {
        if(value.size() > 1) return false;
        if (value.size() == 1) {
            move = new Move(GoUtils.parseCoord(value.get(0).charAt(0)),GoUtils.parseCoord(value.get(0).charAt(1)));
        } else {
            move = GoValueTypes.PASS;
        }
        return true;
    }

    public Object getSGFValue() {
        return move;
    }

    public Move getMove() {
        return move;
    }
}
