package LoggingFramework;

public class WarnProcessor extends LogProcessor {
    public WarnProcessor(LogProcessor next)
    {
        super(next);
        this.logLevel=LogLevel.WARN;
    }

}
