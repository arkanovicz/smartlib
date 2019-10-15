package com.republicate.sgf.properties;

import com.republicate.sgf.MoveProperty;
import com.republicate.sgf.types.ValueType;
import com.republicate.sgf.types.ValueTypes;

import java.util.List;

/**
 * Execute a given move (B or W) even it's illegal.
 * A KO property without a black or white move within
 * the same node is illegal.
 */
public class KO extends MoveProperty {

    public ValueType getValueType() {
        return ValueTypes.NONE;
    }

    public Object getSGFValue() {
        return "";
    }

    public boolean addValue(List<String> value) {
        return false;
    }
}
