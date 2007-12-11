package sgf;

import sgf.Property;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 9 déc. 2007
 * Time: 11:48:45
 * To change this template use File | Settings | File Templates.
 */
public abstract class RootProperty extends Property {

    public PropertyType getPropertyType() {
        return PropertyType.root;
    }
}
