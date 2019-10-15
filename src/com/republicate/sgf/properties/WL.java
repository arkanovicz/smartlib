package com.republicate.sgf.properties;

import com.republicate.sgf.TimingProperty;
import com.republicate.sgf.types.ValueType;
import com.republicate.sgf.types.ValueTypes;

import java.util.List;

/**
 * Time left for white after the move was made.
 */
public class WL extends TimingProperty {

    double seconds = 0;

    public ValueType getValueType() {
        return ValueTypes.REAL;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1) return false;
        try {
            seconds = Double.parseDouble(value.get(0));
            return true;
        } catch(NumberFormatException nfe) {
            return false;
        }
    }

    public Object getSGFValue() {
        return seconds;
    }

    public double getTimeLeft() {
        return seconds;
    }
}
