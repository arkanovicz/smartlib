package sgf.types;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 10 déc. 2007
 * Time: 01:44:31
 * To change this template use File | Settings | File Templates.
 */
public class ValueList<T extends ValueType> implements ValueType {

    private T component;

    public ValueList(T component) {
        this.component = component;
    }

    public String getPattern() {
        if(component instanceof Point || component instanceof Stone) {
            return  component.getPattern() + "(?:\\s*:\\s*"+component.getPattern()+")?";
        } else {
            return component.getPattern();
        }
    }
}
