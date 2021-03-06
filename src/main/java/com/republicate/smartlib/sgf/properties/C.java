package com.republicate.smartlib.sgf.properties;

import com.republicate.smartlib.sgf.AnnotationProperty;
import com.republicate.smartlib.sgf.types.ValueType;
import com.republicate.smartlib.sgf.types.ValueTypes;
import com.republicate.smartlib.sgf.types.Text;

import java.util.List;

/**
 * Provides a comment text for the given node.
 */
public class C extends AnnotationProperty {

    private String text = null;

    public ValueType getValueType() {
        return ValueTypes.TEXT;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1) return false;
        text = Text.unescape(value.get(0));
        return true;
    }

    public Object getSGFValue() {
        return Text.escape(text);
    }

    public String getText() {
        return text;
    }
}
