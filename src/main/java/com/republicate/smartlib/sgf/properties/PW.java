package com.republicate.smartlib.sgf.properties;

import com.republicate.smartlib.sgf.InfoProperty;
import com.republicate.smartlib.sgf.types.ValueType;
import com.republicate.smartlib.sgf.types.ValueTypes;
import com.republicate.smartlib.sgf.types.SimpleText;

import java.util.List;

/**
 * Provides the name of the white player.
 */
public class PW extends InfoProperty {

    private String player = null;

    public ValueType getValueType() {
        return ValueTypes.SIMPLE_TEXT;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1) return false;
        player = SimpleText.unescape(value.get(0));
        return true;
    }

    public Object getSGFValue() {
        return SimpleText.escape(player);
    }

    public String getPlayer() {
        return player;
    }
}
