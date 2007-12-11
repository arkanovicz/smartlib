package sgf.properties;

import sgf.SetupProperty;
import sgf.GameType;
import sgf.types.ValueType;
import sgf.types.ValueTypes;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 10 déc. 2007
 * Time: 15:35:40
 * To change this template use File | Settings | File Templates.
 */
public class GM extends SetupProperty {

    private GameType gameType = null;

    public ValueType getValueType() {
        return ValueTypes.NUMBER;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1) return false;
        try {
            gameType = GameType.getType(Integer.parseInt(value.get(0)));
            return true;
        } catch(NumberFormatException nfe) {
            return false;
        }
    }

    public Object getSGFValue() {
        return gameType;
    }

    public GameType getGameType() {
        return gameType;
    }
}
