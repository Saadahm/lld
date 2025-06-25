package LoggingFramework;

class InfoProcessor extends LogProcessor {
    public InfoProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
        this.logLevel = LogLevel.INFO;
    }
}
