package sgf.types.go;

import sgf.types.ComposedSimpleText;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 10 déc. 2007
 * Time: 15:17:56
 * To change this template use File | Settings | File Templates.
 */
public class Annotation {

    private Point point = null;
    private String text = null;

    public Annotation() {}

    public Annotation(Point point,String text) {
        this.point = point;
        this.text = text;
    }

    public Point getPoint() {
        return point;
    }

    public String getText() {
        return text;
    }

    public String toString() {
        return String.valueOf(point)+":"+ ComposedSimpleText.escape(text);
    }
}
