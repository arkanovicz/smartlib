package sgf.types.go;

public class Move extends Point implements sgf.types.Move {

    public Move() {
    }

    public Move(int col, int row) {
        super(col,row);
    }
    
    public String getPattern() {
        // 'pass' is the empty move
        return "([a-zA-Z][a-zA-Z])?";
    }

    public String toString() {
        if(this.equals(GoValueTypes.PASS)) return "";
        else return super.toString();
    }

}
