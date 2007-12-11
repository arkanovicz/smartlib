package sgf.properties;

import sgf.InfoProperty;
import sgf.types.ValueType;
import sgf.types.ValueTypes;
import sgf.types.Text;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 10 déc. 2007
 * Time: 16:39:28
 * To change this template use File | Settings | File Templates.
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
