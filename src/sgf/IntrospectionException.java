package sgf;

/**
 * Created by IntelliJ IDEA.
 * User: claude
 * Date: 16 déc. 2007
 * Time: 09:22:51
 * To change this template use File | Settings | File Templates.
 */
public class IntrospectionException extends Exception {

    public IntrospectionException() {}
    
    public IntrospectionException(String msg) {
        super(msg);
    }

    public IntrospectionException(Throwable cause) {
        super(cause);
    }

    public IntrospectionException(String msg,Throwable cause) {
        super(msg,cause);
    }
}
