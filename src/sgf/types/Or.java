package sgf.types;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 10 déc. 2007
 * Time: 16:06:32
 * To change this template use File | Settings | File Templates.
 */
public class Or<L extends ValueType,R extends ValueType> implements ValueType {

    L left = null;
    R right = null;

    public Or(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public String getPattern() {
        return "(?:"+left.getPattern()+")|(?:"+right.getPattern()+")";
    }

}
