package com.republicate.sgf.properties.go;

import com.republicate.sgf.types.ValueType;
import com.republicate.sgf.types.go.Stone;
import com.republicate.sgf.types.go.GoValueTypes;
import com.republicate.sgf.types.ValueEList;

import java.util.List;
import java.util.ArrayList;

import com.republicate.util.GoUtils;
import com.republicate.util.Lists;

/**
 * Add black stones to the board.
 */
public class AB extends com.republicate.sgf.properties.AB {

    private List<Stone> stones = new ArrayList<Stone>();

    private static ValueType valueType = new ValueEList<Stone>(GoValueTypes.STONE);

    public ValueType getValueType() {
        return valueType;
    }

    public boolean addValue(List<String> value) {
        return GoUtils.addEListValue(value,stones,Stone.class);
    }

    public int removeValue(List<String> value) {
        GoUtils.removeEListValue(value,stones,Stone.class);
        return stones.size();
    }

    public Object getSGFValue() {
        return Lists.join(stones,"][");
    }

    public int getSize() {
        return stones.size();
    }

    public Stone get(int index) {
        return stones.get(index);
    }    
}
