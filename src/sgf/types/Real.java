package sgf.types;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 10 déc. 2007
 * Time: 12:52:11
 * To change this template use File | Settings | File Templates.
 */
public class Real implements ValueType {
    public String getPattern() {
        return "((?:\\+|-)?\\d+(?:\\.\\d+)?)";
    }
}
