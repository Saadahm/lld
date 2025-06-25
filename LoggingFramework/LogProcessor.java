package LoggingFramework;

public abstract class LogProcessor {
    LogLevel logLevel;
    LogProcessor next;
    public LogProcessor(LogProcessor logProcessor)
    {
        this.next=logProcessor;
    }
    public void process(LogLevel logLevel, String message) {
        if (this.logLevel == logLevel) {
            handleMessage(message);
        } else if (next != null) {
            next.process(logLevel, message);
        } else {
            System.out.println("No");
        }
    }
    protected void handleMessage(String message) {
        Logger.getInstance().appendToAppenders(message);
    }

}
