package com.republicate.smartlib.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

/** This class is the logger used by smartlib.
 *
 *  @author <a href=mailto:claude.brisson@gmail.com>Claude Brisson</a>
 */
public class Logger
{
    /**
     * trace messages loglevel.
     */
    public final static int TRACE_ID = 0;

    /**
     * debug messages loglevel.
     */
    public final static int DEBUG_ID = 1;

    /**
     * info messages loglevel.
     */
    public final static int INFO_ID = 2;

    /**
     * warn messages loglevel.
     */
    public final static int WARN_ID = 3;

    /**
     * error messages loglevel.
     */
    public final static int ERROR_ID = 4;

    /**
     * fatal messages loglevel.
     */
    public final static int FATAL_ID = 5;


    /**
     * Current log level.
     */
    private static int logLevel = INFO_ID;

    /**
     * whether to display timestamps.
     */
    private static boolean displayTimestamps = false;

    /**
     * whether the logger captures stdout.
     */
    private static boolean captureStdout = false;

    /**
     * whether the logger captures stderr.
     */
    private static boolean captureStderr;

    /**
     * max number of lines to log in asynchronous mode.
     */
    private static int asyncLimit = 50;

    /**
     * Did someone give me an otput writer?
     */
    private static boolean initialized = false;

    /** Sets the log level.
     * @param logLevel log level
     */
    public static void setLogLevel(int logLevel) {
        Logger.logLevel = logLevel;
    }

    /** whether to display timestamps.
     * @param timestamps boolean
     */
    public static void setDisplayTimestamps(boolean timestamps) {
        displayTimestamps = timestamps;
    }

    /** Gets the current log level.
     * @return the current log level
     */
    public static int getLogLevel() {
        return logLevel;
    }

    /** date format for timestamps.
     */
    static SimpleDateFormat format = null;
    /** asynchronous log used at start.
     */
    static StringWriter asyncLog = null;
    /** log output printwriter.
     */
    static PrintWriter log = null;
    static
    {
        try {
            format = new SimpleDateFormat("[yyyy/MM/dd HH:mm:ss]");
            // initialize with an asynchronous buffer
            asyncLog = new StringWriter();
            log = new PrintWriter(asyncLog);
            info("log initialized");
        }
        catch (Throwable e) {
            System.err.println("no log!");
            e.printStackTrace(System.err);
        }
    }

    /** stdout old value.
     */
    static PrintStream oldStdout = null;
    /** stderr old value.
     */
    static PrintStream oldStderr = null;

    /** logs a string.
     *
     * @param s string
     */
    static private void log(String s) {
        log.println(header()+s);
        log.flush();
    }

    /** logs an exception with a string.
     *
     * @param s string
     * @param e exception
     */
    static public void log(String s,Throwable e) {
        error(s);
        e.printStackTrace(log);
        log.flush();
    }

    /** log an exception.
     *
     * @param e exception
     */
    static public void log(Throwable e) {
        String msg=e.getMessage();
        log((msg!=null?msg:""),e);
    }

    static int lines = 0;

    /** log a string using a verbose level.
     *
     * @param level verbose level
     * @param s string to log
     */
    static public void log(int level,String s) {
        if (level < logLevel) return;
        String prefix="";
        switch(level) {
            case TRACE_ID:
                prefix=" [trace] ";
                break;
            case DEBUG_ID:
                prefix=" [debug] ";
                break;
            case INFO_ID:
                prefix="  [info] ";
                break;
            case WARN_ID:
                prefix="  [warn] ";
                break;
            case ERROR_ID:
                prefix=" [error] ";
                break;
            case FATAL_ID:
                prefix=" [fatal] ";
                break;
        }
        log(prefix+s);
        lines++;
        // no more than 100 lines in asynchronous mode
        if (asyncLog != null && lines >asyncLimit) {
//            warn("More than "+asyncLimit+" lines in asynchronous logging mode...");
//            warn("Automatically switching to stderr");
            log2Stderr();
            flushAsyncLog();
        }
    }

    /** logs a tracing string.
     *
     * @param s tracing string
     */
    static public void trace(String s) {
        log(TRACE_ID,s);
    }

    /** logs a debug string.
     *
     * @param s debug string
     */
    static public void debug(String s) {
        log(DEBUG_ID,s);
    }

    /** logs an info string.
     *
     * @param s info string
     */
    static public void info(String s) {
        log(INFO_ID,s);
    }

    /** logs a warning string.
     *
     * @param s warning string
     */
    static public void warn(String s) {
        log(WARN_ID,s);
    }

    /** logs an error string.
     *
     * @param s error string
     */
    static public void error(String s) {
        log(ERROR_ID,s);
    }

    /** logs a fatal error string.
     *
     * @param s fatal error string
     */
    static public void fatal(String s) {
        log(ERROR_ID,s);
    }

    /** get the output writer.
     *
     * @return writer
     */
    static public PrintWriter getWriter() {
        return log;
    }

    /** set the output writer.
     *
     * @param out PrintWriter or Writer or OutputStream
     */
    static public void setWriter(Object out) {
        if (log!=null) {
            log.flush();
            log.close();
        }
        if (out instanceof PrintWriter) log = (PrintWriter)out;
        else if (out instanceof Writer) log = new PrintWriter((Writer)out);
        else if (out instanceof OutputStream) log = new PrintWriter((OutputStream)out);
        else throw new RuntimeException("Logger.setWriter: PANIC! class "+out.getClass().getName()+" cannot be used to build a PrintWriter!");
        if (asyncLog != null) flushAsyncLog();
        initialized = true;
    }

    /** redirects stdout towards output writer.
     */
    static public void startCaptureStdout() {
        oldStdout = System.out;
        System.setOut(new PrintStream(new WriterOutputStream(log)));
        captureStdout = true;
    }

    /** stop redirecting stdout.
     */
    static public void stopCaptureStdout() {
        if (captureStdout) System.setOut(oldStdout);
        captureStdout = false;
    }

    /** redirects stderr towards the output writer.
     */
    static public void startCaptureStderr() {
        oldStderr = System.err;
        System.setErr(new PrintStream(new WriterOutputStream(log)));
        captureStderr = true;
    }

    /** stops redirecting stderr.
     */
    static public void stopCaptureStderr() {
        if (captureStderr) System.setErr(oldStderr);
        captureStderr = false;
    }

    /** log to stdout.
      */
    static public void log2Stdout() {
        stopCaptureStdout();
        stopCaptureStderr();
        log = new PrintWriter(System.out);
        flushAsyncLog();
    }

    /** log to stderr.
     */
    static public void log2Stderr() {
        stopCaptureStdout();
        stopCaptureStderr();
        log = new PrintWriter(System.err);
        flushAsyncLog();
    }

    /** log to file.
     * @param file file
     * @throws FileNotFoundException when file is not found
     * @throws IOException on other i/o errors
     */
    static public void log2File(String file) throws FileNotFoundException,IOException {
        log = new PrintWriter(new FileWriter(file,true));
		log.println();
		log.println("=================================================");
        flushAsyncLog();
    }

    /** returns "smartlib ".
     *
     * @return return the header
     */
    static private String header() {
        return displayTimestamps ? format.format(new Date())+ " smartlib " : " smartlib ";
    }

    /** flush the asynchronous log in the output writer.
     */
    static private void flushAsyncLog() {
        if (asyncLog != null) {
            try {
                log(asyncLog.toString());
                asyncLog.close();
                asyncLog = null;
            }
            catch (IOException ioe) {
                log(ioe);
            }
        }
    }

    /** queries the initialized state.
     * @return initialized state
     *
     */
    static public boolean isInitialized() {
        return initialized;
    }

    /** dumps the current stack.
     */
    static public void dumpStack() {
        try {
            throw new Exception("dumpStack");
        }
        catch (Exception e) {
            e.printStackTrace(log);
        }
    }
}
