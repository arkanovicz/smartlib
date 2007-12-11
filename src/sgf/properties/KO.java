package sgf.properties;

import sgf.MoveProperty;
import sgf.types.ValueType;
import sgf.types.ValueTypes;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 9 déc. 2007
 * Time: 13:28:19
 * To change this template use File | Settings | File Templates.
 */
public class KO extends MoveProperty {

    public ValueType getValueType() {
        return ValueTypes.NONE;
    }

    public Object getSGFValue() {
        return "";
    }

    public boolean addValue(List<String> value) {
        return false;
    }
}
