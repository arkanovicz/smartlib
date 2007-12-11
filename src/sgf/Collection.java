package sgf;

import java.util.ArrayList;

public class Collection extends ArrayList<Game> {

    public String toString() {
        String sup = super.toString();
        return "("+sup.substring(1,sup.length()-1)+")";
    }
}
