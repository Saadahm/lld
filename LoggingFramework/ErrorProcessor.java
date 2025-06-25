package LoggingFramework;

class ErrorProcessor extends LogProcessor {
    public ErrorProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
        this.logLevel = LogLevel.ERROR;
    }
}