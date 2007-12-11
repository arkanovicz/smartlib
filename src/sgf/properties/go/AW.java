package sgf.properties.go;

import sgf.types.ValueType;
import sgf.types.go.Stone;
import sgf.types.go.GoValueTypes;
import sgf.types.ValueEList;

import java.util.List;
import java.util.ArrayList;

import util.GoUtils;
import util.Lists;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 10 déc. 2007
 * Time: 02:15:43
 * To change this template use File | Settings | File Templates.
 */
public class AW extends sgf.properties.AW {

    private List<Stone> stones = new ArrayList<Stone>();

    private static ValueType valueType = new ValueEList<Stone>(GoValueTypes.STONE);

    public ValueType getValueType() {
        return valueType;
    }

    public boolean addValue(List<String> value) {
        return GoUtils.addEListValue(value,stones,Stone.class);
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
