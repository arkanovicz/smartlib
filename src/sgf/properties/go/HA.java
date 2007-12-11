package sgf.properties.go;

import sgf.InfoProperty;
import sgf.types.ValueType;
import sgf.types.ValueTypes;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 11 déc. 2007
 * Time: 09:55:08
 * To change this template use File | Settings | File Templates.
 */
public class HA extends InfoProperty {

    private int handicap = 0;

    public ValueType getValueType() {
        return ValueTypes.NUMBER;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1) return false;
        try {
            handicap = Integer.parseInt(value.get(0));
            return true;
        } catch(NumberFormatException nfe) {
            return false;
        }
    }

    public Object getSGFValue() {
        return handicap;
    }

    public int getHandicap() {
        return handicap;
    }
}
