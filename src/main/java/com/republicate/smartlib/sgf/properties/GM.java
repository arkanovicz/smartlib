package com.republicate.smartlib.sgf.properties;

import com.republicate.smartlib.sgf.RootProperty;
import com.republicate.smartlib.sgf.GameType;
import com.republicate.smartlib.sgf.types.ValueType;
import com.republicate.smartlib.sgf.types.ValueTypes;

import java.util.List;

/**
 * Defines the type of game, which is stored in the current
 * gametree.
 */
public class GM extends RootProperty {

    private GameType gameType = null;

    public ValueType getValueType() {
        return ValueTypes.NUMBER;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1) return false;
        try {
            gameType = GameType.getType(Integer.parseInt(value.get(0)));
            return true;
        } catch(NumberFormatException nfe) {
            return false;
        }
    }

    public Object getSGFValue() {
        return gameType.getType();
    }

    public GameType getGameType() {
        return gameType;
    }
}
