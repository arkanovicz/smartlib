package com.republicate.sgf.properties;

import com.republicate.sgf.RootProperty;
import com.republicate.sgf.types.ValueType;
import com.republicate.sgf.types.ValueTypes;

import java.util.List;

/**
 * Defines the used file format.
 */
public class FF extends RootProperty {

    private int version = 0;

    public ValueType getValueType() {
        return ValueTypes.NUMBER;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1) return false;
        try {
            version = Integer.parseInt(value.get(0));
            return true;
        } catch(NumberFormatException nfe) {
            return false;
        }
    }

    public Object getSGFValue() {
        return version;
    }

    public int getVersion() {
        return version;
    }
}
