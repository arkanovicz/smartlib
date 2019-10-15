package com.republicate.sgf.properties;

import com.republicate.sgf.InfoProperty;
import com.republicate.sgf.types.ValueType;
import com.republicate.sgf.types.ValueTypes;
import com.republicate.sgf.types.Text;

import java.util.List;

/**
 * Provides some extra information about the following game.
 */
public class GC extends InfoProperty {

    private String comment = null;

    public ValueType getValueType() {
        return ValueTypes.TEXT;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1) return false;
        comment = Text.unescape(value.get(0));
        return true;
    }

    public Object getSGFValue() {
        return Text.escape(comment);
    }

    public String getComment() {
        return comment;
    }
}
