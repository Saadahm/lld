package LoggingFramework;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.addAppender(new ConsoleAppender());

        logger.log(LogLevel.DEBUG, "Starting application");
        logger.log(LogLevel.INFO, "Application initialized");
        logger.log(LogLevel.WARN, "Low memory warning");
        logger.log(LogLevel.ERROR, "Critical error occurred");

        logger.log(LogLevel.INFO, "Another info message");
    }
}
