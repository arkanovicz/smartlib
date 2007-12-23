package sgf;

import java.util.ArrayList;

public class GameCollection extends ArrayList<Node> {

    public String toString() {
        StringBuilder builder = new StringBuilder();
        int n = 0;
        for(Node game:this) {
            builder.append("\ngame #"+(++n));
            builder.append(game.toString());
        }
        return builder.toString();
    }
}
