package com.republicate.sgf.properties;

import com.republicate.sgf.AnnotationProperty;
import com.republicate.sgf.types.ValueType;
import com.republicate.sgf.types.ValueTypes;

import java.util.List;

/**
 * Something good for black.
 */
public class GB extends AnnotationProperty {

    private int emphasis = 0;

    public ValueType getValueType() {
        return ValueTypes.DOUBLE;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1) return false;
        try {
            emphasis = Integer.parseInt(value.get(0));
            return true;
        } catch(NumberFormatException nfe) {
            return false;
        }
    }

    public Object getSGFValue() {
        return emphasis;
    }

    public int getEmphasis() {
        return emphasis;
    }
}
