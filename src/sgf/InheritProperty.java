package sgf;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 10 déc. 2007
 * Time: 17:07:10
 * To change this template use File | Settings | File Templates.
 */
public abstract class InheritProperty extends Property {
    public PropertyType getPropertyType() {
        return PropertyType.inherit;
    }

    public boolean doesPersist() { return true; }
}
