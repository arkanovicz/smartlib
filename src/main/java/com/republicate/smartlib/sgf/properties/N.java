package com.republicate.smartlib.sgf.properties;

import com.republicate.smartlib.sgf.AnnotationProperty;
import com.republicate.smartlib.sgf.types.ValueType;
import com.republicate.smartlib.sgf.types.ValueTypes;
import com.republicate.smartlib.sgf.types.SimpleText;

import java.util.List;

/**
 * Provides a name for the node.
 */
public class N extends AnnotationProperty {

    private String name = null;

    public ValueType getValueType() {
        return ValueTypes.SIMPLE_TEXT;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1) return false;
        name = SimpleText.unescape(value.get(0));
        return true;
    }

    public Object getSGFValue() {
        return SimpleText.escape(name);
    }

    public String getName() {
        return name;
    }
}
