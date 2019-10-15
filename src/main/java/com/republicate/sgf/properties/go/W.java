package com.republicate.sgf.properties.go;

import com.republicate.sgf.types.ValueType;
import com.republicate.sgf.types.go.GoValueTypes;
import com.republicate.sgf.types.go.Move;

import java.util.List;

import com.republicate.util.GoUtils;

/**
 * Execute a white move.
 */
public class W extends com.republicate.sgf.properties.W {

    private Move move = null;

    public ValueType getValueType() {
        return GoValueTypes.MOVE;
    }

    public boolean addValue(List<String> value) {
        if(value.size() > 1) return false;
        if (value.size() == 1) {
            String coords = value.get(0);
            // TODO tt==pass only for 19x19 (?)
            if (coords.length() == 0 || coords.charAt(0) == 't' && coords.charAt(1) == 't') {
                move = GoValueTypes.PASS;
            } else {
                move = new Move(GoUtils.parseCoord(coords.charAt(0)),GoUtils.parseCoord(coords.charAt(1)));
            }
        } else {
            move = GoValueTypes.PASS;
        }
        return true;
    }

    public Object getSGFValue() {
        return move;
    }

    public Move getMove() {
        return move;
    }
}
