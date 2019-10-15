package com.republicate.smartlib.sgf.properties;

import com.republicate.smartlib.sgf.RootProperty;
import com.republicate.smartlib.sgf.types.Compose;
import com.republicate.smartlib.sgf.types.ValueType;
import com.republicate.smartlib.sgf.types.ValueTypes;
import com.republicate.smartlib.sgf.types.ComposedSimpleText;

import java.util.List;

/**
 * Provides the name and version number of the application used
 * to create this gametree.
 */

public class AP extends RootProperty {

    private String application = null;
    private String version = null;

    private static ValueType valueType = new Compose<ComposedSimpleText,ComposedSimpleText>(ValueTypes.COMPOSED_SIMPLE_TEXT, ValueTypes.COMPOSED_SIMPLE_TEXT);

    public ValueType getValueType() {
        return valueType;
    }

    public boolean addValue(List<String> value) {
        if(value.size() == 1) {
            application = ComposedSimpleText.unescape(value.get(0));
            // a version number should be provided...
            // return false!
            return false;
        } else if(value.size() != 2) return false;
        application = ComposedSimpleText.unescape(value.get(0));
        version = ComposedSimpleText.unescape(value.get(1));
        return true;
    }

    public Object getSGFValue() {
        return ComposedSimpleText.escape(application)+":"+ComposedSimpleText.escape(version);
    }

    public String getApplication() {
        return application;
    }

    public String getVersion() {
        return version;
    }
}
