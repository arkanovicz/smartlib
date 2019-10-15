package com.republicate.smartlib.sgf.properties;

import com.republicate.smartlib.sgf.SetupProperty;
import com.republicate.smartlib.sgf.types.*;

import java.util.List;

/**
 * The figure property is used to divide a game into
 * different figures for printing: a new figure starts at the
 * node containing a figure property.
 */
public class FG extends SetupProperty {

    private static ValueType valueType = new Or<None, Compose<com.republicate.smartlib.sgf.types.Number, ComposedSimpleText>>(ValueTypes.NONE,new Compose<com.republicate.smartlib.sgf.types.Number, ComposedSimpleText>(ValueTypes.NUMBER,ValueTypes.COMPOSED_SIMPLE_TEXT));

    private int flags = 0;
    private String name = null;

    public ValueType getValueType() {
        return valueType;
    }

    public boolean addValue(List<String> value) {
        if(value.size() > 0) {
            if(value.size() != 2) return false;
            try {
                flags = Integer.parseInt(value.get(0));
            } catch(NumberFormatException nfe) {
                return false;
            }
            name = ComposedSimpleText.unescape(value.get(1));
        }
        return true;
    }

    public Object getSGFValue() {
        return name == null ? "" : String.valueOf(flags)+":"+ComposedSimpleText.escape(name);
    }

    public int getFlags() {
        return flags;
    }

    public String getName() {
        return name;
    }
}
