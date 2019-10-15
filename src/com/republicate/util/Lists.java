package com.republicate.util;

import java.util.Iterator;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 11 déc. 2007
 * Time: 08:57:44
 * To change this template use File | Settings | File Templates.
 */
public class Lists {
    /** joins strings using a separator.
     *
     * @param list strings to join
     * @param joinString separator to include between strings
     * @return the result of the join
     */
    public static String join(Collection list,String joinString) {
        Iterator i=list.iterator();

        StringBuffer result = new StringBuffer();

        if (!i.hasNext()) return "";

        result.append(i.next().toString());

        while (i.hasNext()) {
            result.append(joinString);
            result.append(i.next().toString());
        }
        return result.toString();
    }
}
