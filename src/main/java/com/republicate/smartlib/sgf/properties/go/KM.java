package com.republicate.smartlib.sgf.properties.go;

import com.republicate.smartlib.sgf.InfoProperty;
import com.republicate.smartlib.sgf.types.ValueType;
import com.republicate.smartlib.sgf.types.ValueTypes;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 11 déc. 2007
 * Time: 09:52:44
 * To change this template use File | Settings | File Templates.
 */
public class KM extends InfoProperty {

    private double komi = 0;

    public ValueType getValueType() {
        return ValueTypes.REAL;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1) return false;
        try {
            komi = Double.parseDouble(value.get(0));
            return true;
        } catch(NumberFormatException nfe) {
            return false;
        }
    }

    public Object getSGFValue() {
        return komi;
    }

    public double getKomi() {
        return komi;
    }
}
