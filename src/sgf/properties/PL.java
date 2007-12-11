package sgf.properties;

import sgf.SetupProperty;
import sgf.Color;
import sgf.types.ValueType;
import sgf.types.ValueTypes;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 10 déc. 2007
 * Time: 12:15:20
 * To change this template use File | Settings | File Templates.
 */
public class PL extends SetupProperty {

    private Color color = null;

    public ValueType getValueType() {
        return ValueTypes.COLOR;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1) {
            return false;
        }
        char col = Character.toUpperCase(value.get(0).charAt(0));
        if (col == 'B') color = Color.black;
        else if (col == 'W') color = Color.white;
        else return false;
        return true;
    }

    public Object getSGFValue() {
        return color;
    }

    public Color getColor() {
        return color;
    }
}
