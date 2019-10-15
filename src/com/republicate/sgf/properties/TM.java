package com.republicate.sgf.properties;

import com.republicate.sgf.InfoProperty;
import com.republicate.sgf.types.ValueType;
import com.republicate.sgf.types.ValueTypes;

import java.util.List;

/**
 * Provides the time limits of the game.
 */
public class TM extends InfoProperty {

    private double seconds = 0;

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

    public double getTimeLimit() {
        return seconds;
    }
}
