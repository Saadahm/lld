package TextEditorCommand;

public class InsertCommand implements Command{
    private TextBuffer textBuffer;
    private String s;
    public InsertCommand(TextBuffer textBuffer, String s)
    {
        this.textBuffer=textBuffer;
        this.s=s;
    }
    @Override
    public void undo() {
        textBuffer.delete(s.length());
    }

    @Override
    public void execute() {
        textBuffer.insert(s);
    }
}
