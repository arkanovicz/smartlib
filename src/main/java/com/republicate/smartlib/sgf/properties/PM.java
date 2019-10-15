package com.republicate.smartlib.sgf.properties;

import com.republicate.smartlib.sgf.InheritProperty;
import com.republicate.smartlib.sgf.types.ValueType;
import com.republicate.smartlib.sgf.types.ValueTypes;

import java.util.List;

/**
 * Specifies how move numbers should be printed.
 */
public class PM extends InheritProperty {

    private int mode = 0;

    public ValueType getValueType() {
        return ValueTypes.NUMBER;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1) return false;
        try {
            mode = Integer.parseInt(value.get(0));
            return true;
        } catch(NumberFormatException nfe) {
            return false;
        }
    }

    public Object getSGFValue() {
        return mode;
    }

    public int getMode() {
        return mode;
    }
}
