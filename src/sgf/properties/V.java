package sgf.properties;

import sgf.Property;
import sgf.types.ValueType;
import sgf.types.ValueTypes;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 10 déc. 2007
 * Time: 13:03:55
 * To change this template use File | Settings | File Templates.
 */
public class V extends Property {

    private double value = 0;

    public ValueType getValueType() {
        return ValueTypes.REAL;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1) return false;
        try {
            this.value = Double.parseDouble(value.get(0));
            return true;
        } catch(NumberFormatException nfe) {
            return false;
        }
    }

    public Object getSGFValue() {
        return value;
    }

    public double getNodeValue() {
        return value;
    }
}
