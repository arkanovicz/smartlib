package sgf.types;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 10 déc. 2007
 * Time: 12:14:34
 * To change this template use File | Settings | File Templates.
 */
public class Color implements ValueType {
    public String getPattern() {
        return "(b|B|w|W)";
    }
}
