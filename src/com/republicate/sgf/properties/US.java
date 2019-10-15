package com.republicate.sgf.properties;

import com.republicate.sgf.InfoProperty;
import com.republicate.sgf.types.ValueType;
import com.republicate.sgf.types.ValueTypes;
import com.republicate.sgf.types.SimpleText;

import java.util.List;

/**
 * Provides the name of the user (or program), who entered
 * the game.
 */
public class US extends InfoProperty {

    private String user = null;

    public ValueType getValueType() {
        return ValueTypes.SIMPLE_TEXT;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1) return false;
        user = SimpleText.unescape(value.get(0));
        return true;
    }

    public Object getSGFValue() {
        return SimpleText.escape(user);
    }

    public String getUser() {
        return user;
    }
}