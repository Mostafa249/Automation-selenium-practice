package Utiliti;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.LoggerContext;

import java.io.File;

public class Log {

    // Initialize Log4j logs
    private static Logger log = LogManager.getLogger(Log.class);


    public static void info(String message) {
        LoggerContext context = LogManager.getContext(false);
        File file = new File("src/resource/log4j.xml");
        ((org.apache.logging.log4j.core.LoggerContext) context).setConfigLocation(file.toURI());

        log.info(message);

    }

    public static void warn(String message) {

        Log.warn(message);

    }

    public static void error(String message) {

        Log.error(message);

    }

    public static void fatal(String message) {

        Log.fatal(message);

    }

    public static void debug(String message) {

        Log.debug(message);

    }
}
