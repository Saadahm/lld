package LoggingFramework;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Logger {
    private List<Appender> appenders = new ArrayList<>();
    private LogProcessor logProcessor;
    public static Logger instance;
    public static Logger getInstance()
    {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;

    }
    private Logger() {
        LogProcessor processor = new ErrorProcessor(
                new WarnProcessor(
                        new InfoProcessor(
                                new DebugProcessor(null))));
        this.logProcessor = processor;
    }

    public void addAppender(Appender appender) {
        appenders.add(appender);
    }

    public void log(LogLevel level, String message) {
        logProcessor.process(level, formatMessage(level, message));
    }

    private String formatMessage(LogLevel level, String message) {
        return "[" + level + "] " + new Date() + " - " + message;
    }

    void appendToAppenders(String formattedMessage) {
        for (Appender appender : appenders) {
            appender.append(formattedMessage);
        }
    }

}
