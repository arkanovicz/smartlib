package com.republicate.sgf.properties;

import com.republicate.sgf.InfoProperty;
import com.republicate.sgf.types.ValueType;
import com.republicate.sgf.types.ValueTypes;
import com.republicate.sgf.types.SimpleText;

import java.util.List;

/**
 * Describes the method used for overtime (byo-yomi).
 */
public class OT extends InfoProperty {

    private String timeSystem = null;

    public ValueType getValueType() {
        return ValueTypes.SIMPLE_TEXT;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1) return false;
        timeSystem = SimpleText.unescape(value.get(0));
        return true;
    }

    public Object getSGFValue() {
        return SimpleText.escape(timeSystem);
    }

    public String getTimesystem() {
        return timeSystem;
    }
}
