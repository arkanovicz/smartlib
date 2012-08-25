package sgf.properties.go;

import sgf.types.ValueType;
import sgf.types.Compose;
import sgf.types.ValueTypes;
import sgf.types.ValueList;
import sgf.types.ComposedSimpleText;
import sgf.types.go.Point;
import sgf.types.go.GoValueTypes;
import sgf.types.go.Annotation;

import java.util.List;
import java.util.ArrayList;

import util.GoUtils;
import util.Lists;

/**
 * Writes the given text on the board. The text should be
 * centered around the given point.
 */
public class LB extends sgf.properties.LB {

    private List<Annotation> annotations = new ArrayList<Annotation>();

    private static ValueType valueType = null;

    static {
        Compose<Point, ComposedSimpleText> compType = new Compose<Point, ComposedSimpleText>(GoValueTypes.POINT, ValueTypes.COMPOSED_SIMPLE_TEXT);
        valueType = new ValueList<Compose<Point, ComposedSimpleText>>(compType);
    }

    public ValueType getValueType() {
        return valueType;
    }

    public Object getSGFValue() {
        return Lists.join(annotations,"][");
    }

    public boolean addValue(List<String> value) {
        if(value.size() != 2) return false;
        Point point = new Point(GoUtils.parseCoord(value.get(0).charAt(0)),GoUtils.parseCoord(value.get(0).charAt(1)));
        String text = ComposedSimpleText.unescape(value.get(1));
        annotations.add(new Annotation(point,text));
        return true;
    }

    public int getSize() {
        return annotations.size();
    }

    public Annotation get(int index) {
        return annotations.get(index);
    }
}
