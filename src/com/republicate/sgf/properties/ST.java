package com.republicate.sgf.properties;

import com.republicate.sgf.RootProperty;
import com.republicate.sgf.types.ValueType;
import com.republicate.sgf.types.ValueTypes;

import java.util.List;

/**
 * Defines how variations should be shown. Binary mask:
 * <ul>
 * <li>0 / 1: show variations of successor node (children) / show variations of current node (sibling)</li>
 * <li>0 / 2: do board markup / no (auto-) board markup</li>
 * </ul>
 */
public class ST extends RootProperty {

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
