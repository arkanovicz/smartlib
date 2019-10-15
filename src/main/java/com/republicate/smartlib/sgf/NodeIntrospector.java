package com.republicate.smartlib.sgf;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 12 déc. 2007
 * Time: 11:12:22
 * To change this template use File | Settings | File Templates.
 */
public interface NodeIntrospector {

    public void introspect(Node node) throws IntrospectionException;
    public void down(Node parent) throws IntrospectionException;
    public void up(Node parent) throws IntrospectionException;
}
