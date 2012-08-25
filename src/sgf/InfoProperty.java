package sgf;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 10 déc. 2007
 * Time: 16:38:19
 * To change this template use File | Settings | File Templates.
 */
public abstract class InfoProperty extends Property {

    public PropertyType getPropertyType() {
        return PropertyType.info;
    }
}
