package sgf;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 8 déc. 2007
 * Time: 16:32:59
 * To change this template use File | Settings | File Templates.
 */
public class Game extends Node {

    public String toString() {
        StringBuilder result = new StringBuilder();
        if(children != null) {
            for(Node child:children) {
                result.append(child.toString());
            }
        }
        return result.toString();
    }
}
