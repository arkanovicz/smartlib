package com.republicate.sgf.properties;

import com.republicate.sgf.RootProperty;
import com.republicate.sgf.types.ValueType;
import com.republicate.sgf.types.ValueTypes;
import com.republicate.sgf.types.SimpleText;

import java.util.List;

/**
 * Provides the used charset for SimpleText and Text type.
 */
public class CA extends RootProperty {

    private String encoding = null;

    public ValueType getValueType() {
        return ValueTypes.SIMPLE_TEXT;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1) return false;  //To change body of implemented methods use File | Settings | File Templates.
        encoding = SimpleText.unescape(value.get(0));
        return true;
    }

    public Object getSGFValue() {
        return SimpleText.escape(encoding);
    }

    public String getEncoding() {
        return encoding;
    }
}
