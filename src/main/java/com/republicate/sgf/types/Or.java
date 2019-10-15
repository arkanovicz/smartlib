package com.republicate.sgf.types;

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
      String leftPattern = left.getPattern();
      String rightPattern = right.getPattern();
      if(leftPattern.length() > 0)
      {
        return "(?:"+leftPattern+")|(?:"+rightPattern+")";
      }
      else
      {
        return "(?:"+rightPattern+")?";
      }
    }

    public String getName() {
      return "Or<" + left.getName() + "," + right.getName() + ">";
    }
}
