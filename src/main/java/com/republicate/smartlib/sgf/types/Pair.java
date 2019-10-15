package com.republicate.smartlib.sgf.types;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 11 déc. 2007
 * Time: 09:01:18
 * To change this template use File | Settings | File Templates.
 */
public class Pair<C extends ValueType> {

    private C first = null;
    private C second = null;

    public Pair() {}

    public Pair(C first,C second) {
        this.first = first;
        this.second = second;
    }

    public C getFirst() {
        return first;
    }

    public C getSecond() {
        return second;
    }

    public void setFirst(C first) {
        this.first = first;
    }

    public void setSecond(C second) {
        this.second = second;
    }

    public String toString() {
        return String.valueOf(first)+":"+String.valueOf(second);
    }

    public boolean equals(Object other)
    {
        if (!(other instanceof Pair)) return false;
        Pair<C> otherPair = (Pair<C>)other;
        return first.equals(otherPair.first) && second.equals(otherPair.second);
    }
}
