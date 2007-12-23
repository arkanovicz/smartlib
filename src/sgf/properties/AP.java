package sgf.properties;

import sgf.RootProperty;
import sgf.types.Compose;
import sgf.types.ValueType;
import sgf.types.ValueTypes;
import sgf.types.ComposedSimpleText;

import java.util.List;

/**
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
