package sgf.properties;

import sgf.InfoProperty;
import sgf.types.ValueType;
import sgf.types.ValueTypes;
import sgf.types.SimpleText;

import java.util.List;

/**
 * Provide the name of the white team, if game was part of a
 * team-match
 */
public class WT extends InfoProperty {

    private String team = null;

    public ValueType getValueType() {
        return ValueTypes.SIMPLE_TEXT;
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 1) return false;
        team = SimpleText.unescape(value.get(0));
        return true;
    }

    public Object getSGFValue() {
        return SimpleText.escape(team);
    }

    public String getTeam() {
        return team;
    }
}
