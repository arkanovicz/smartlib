package com.republicate.sgf.properties;

import com.republicate.sgf.InfoProperty;
import com.republicate.sgf.types.ValueType;
import com.republicate.sgf.types.ValueTypes;
import com.republicate.sgf.types.SimpleText;

import java.util.List;

/**
 * Provides the date when the game was played.
 * 
 */
public class DT extends InfoProperty {

    private String date = null;

    public ValueType getValueType() {
        return ValueTypes.SIMPLE_TEXT;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1) return false;
        date = SimpleText.unescape(value.get(0));
        return true;
    }

    public Object getSGFValue() {
        return SimpleText.escape(date);
    }

    public String getDate() {
        return date;
    }
}