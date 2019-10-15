package com.republicate.sgf.properties;

import com.republicate.sgf.TimingProperty;
import com.republicate.sgf.types.ValueType;
import com.republicate.sgf.types.ValueTypes;

import java.util.List;

/**
 * Number of white moves left (after the move of this node was
 * played) to play in this byo-yomi period.
 */
public class OW extends TimingProperty {

    int moves = 0;

    public ValueType getValueType() {
        return ValueTypes.NUMBER;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1) return false;
        try {
            moves = Integer.parseInt(value.get(0));
            return true;
        } catch(NumberFormatException nfe) {
            return false;
        }
    }

    public Object getSGFValue() {
        return moves;
    }

    public int getMovesLeft() {
        return moves;
    }
}
