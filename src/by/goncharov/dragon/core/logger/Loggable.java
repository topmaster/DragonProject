package by.goncharov.dragon.core.logger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description of Loggable class
 *
 * @author Mikita Hancharou
 * @created 28.03.2014 16:26
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@interface Loggable {

    /**
     * Before a method is called, the aspect will log the invocation. You can
     * disable this by setting this property to false. If you're only interested
     * in logging exceptions then it is recommended to set logOnlyExceptions()
     * to true. By doing so you'll automatically stop before and response
     * logging.
     */
    boolean logBefore() default false;

    /**
     * After a method is called, the aspect will log the invocation. You can
     * disable this by setting this property to false. If you're only interested
     * in logging exceptions then it is recommended to set logOnlyExceptions()
     * to true. By doing so you'll automatically stop before and response
     * logging.
     */
    boolean logResponse() default false;

    /**
     * By default all exceptions will be logged. You can disable this if
     * required.
     */
    boolean logExceptions() default true;

    /**
     * By default before, after and exceptions are logged. If you wish to lessen
     * you're logs switch this property to true. By doing so only exceptions
     * will be logged.
     */
    boolean logOnlyExceptions() default true;

    /**
     * In some cases it may be inappropriate to log arguments and results, for
     * example login. In order to prevent the arguments from showing in the logs
     * set this to false. Default is true, which shows the arguments and the
     * results.
     */
    boolean logArgumentsAndResults() default false;

    /**
     * Define the logging level
     */
    LoggingLevel logLevel() default LoggingLevel.INFO;
}
