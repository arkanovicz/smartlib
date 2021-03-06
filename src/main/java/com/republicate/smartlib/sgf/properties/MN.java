package com.republicate.smartlib.sgf.properties;

import com.republicate.smartlib.sgf.MoveProperty;
import com.republicate.smartlib.sgf.types.ValueType;
import com.republicate.smartlib.sgf.types.ValueTypes;

import java.util.List;

/**
 * Sets the move number to the given value.
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
