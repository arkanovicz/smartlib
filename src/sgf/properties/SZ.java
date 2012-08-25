package sgf.properties;

import sgf.RootProperty;
import sgf.types.*;

import java.util.List;

/**
 * Defines the size of the board. If only a single value
 * is given, the board is a square; with two numbers given,
 * rectangular boards are possible.
 * If a rectangular board is specified, the first number specifies
 * the number of columns, the second provides the number of rows.
 */
public class SZ extends RootProperty {

    private static ValueType valueType = new Or<sgf.types.Number,Compose<sgf.types.Number, sgf.types.Number>>(ValueTypes.NUMBER,new Compose<sgf.types.Number,sgf.types.Number>(ValueTypes.NUMBER,ValueTypes.NUMBER));

    private int columns = -1;
    private int rows = -1;

    public ValueType getValueType() {
        return valueType;
    }

    public boolean addValue(List<String> value) {
        if(value.size() == 1) {
            try {
                columns = rows = Integer.parseInt(value.get(0));
            } catch(NumberFormatException nfe) {
                return false;
            }
        } else if (value.size() == 2) {
            try {
                columns = Integer.parseInt(value.get(0));
                rows = Integer.parseInt(value.get(1));
            } catch(NumberFormatException nfe) {
                return false;
            }
        } else return false;
        return true;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public Object getSGFValue() {
        return rows == columns ?  columns : String.valueOf(columns)+":"+String.valueOf(rows);
    }

    public int getSize() {
        return Math.max(columns,rows);
    }
}
