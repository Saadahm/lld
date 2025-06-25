package LoggingFramework;

class DebugProcessor extends LogProcessor {
    public DebugProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
        this.logLevel = LogLevel.DEBUG;
    }
}
