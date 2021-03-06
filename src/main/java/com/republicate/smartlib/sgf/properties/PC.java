package com.republicate.smartlib.sgf.properties;

import com.republicate.smartlib.sgf.InfoProperty;
import com.republicate.smartlib.sgf.types.ValueType;
import com.republicate.smartlib.sgf.types.ValueTypes;
import com.republicate.smartlib.sgf.types.SimpleText;

import java.util.List;

/**
 * Provides the place where the games was played.
 */
public class PC extends InfoProperty {

    private String place = null;

    public ValueType getValueType() {
        return ValueTypes.SIMPLE_TEXT;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1) return false;
        place = SimpleText.unescape(value.get(0));
        return true;
    }

    public Object getSGFValue() {
        return SimpleText.escape(place);
    }

    public String getPlace() {
        return place;
    }
}
