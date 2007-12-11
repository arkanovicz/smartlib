package sgf.properties;

import sgf.SetupProperty;
import sgf.types.ValueType;
import sgf.types.ValueTypes;
import sgf.types.SimpleText;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 10 déc. 2007
 * Time: 15:32:13
 * To change this template use File | Settings | File Templates.
 */
public class CA extends SetupProperty {

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
