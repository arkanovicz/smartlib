package sgf.types;

/**
 */
public class Compose<L extends ValueType,R extends ValueType> implements ValueType {

    private L left = null;
    private R right = null;

    public Compose(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public String getPattern() {
        return left.getPattern()+":"+right.getPattern();
    }

    public String getName() {
        return "Compose<" + left.getName() + "," + right.getName() + ">";
    }
}
