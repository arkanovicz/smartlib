package util;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 10 déc. 2007
 * Time: 11:23:33
 * To change this template use File | Settings | File Templates.
 */
public class Pair<L,R> {

    private L left;
    private R right;

    public Pair() {
        left = null;
        right = null;
    }

    public Pair(L left,R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }

    public void setLeft(L left) {
        this.left = left;
    }

    public void setRight(R right) {
        this.right = right;
    }
}
