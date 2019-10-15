package com.republicate.sgf.properties;

import com.republicate.sgf.InfoProperty;
import com.republicate.sgf.types.ValueType;
import com.republicate.sgf.types.ValueTypes;
import com.republicate.sgf.types.SimpleText;

import java.util.List;

/**
 * Provides the name of the person, who made the annotations
 * to the game.
 */
public class AN extends InfoProperty {

    private String annotator = null;

    public ValueType getValueType() {
        return ValueTypes.SIMPLE_TEXT;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1) return false;
        annotator = SimpleText.unescape(value.get(0));
        return true;
    }

    public Object getSGFValue() {
        return SimpleText.escape(annotator);
    }

    public String getAnnotator() {
        return annotator;
    }
}