package com.republicate.sgf.properties;

import com.republicate.sgf.AnnotationProperty;
import com.republicate.sgf.types.ValueType;
import com.republicate.sgf.types.ValueTypes;

import java.util.List;

/**
 * Define a value for the node.  Positive values are good for
 * black, negative values are good for white.
 */
public class V extends AnnotationProperty {

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
