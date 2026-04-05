package TextEditorCommand;

public class DeleteCommand implements Command {
    private TextBuffer textBuffer;
    private int k;
    private String deleted;
    public DeleteCommand(TextBuffer textBuffer, int k)
    {
        this.textBuffer=textBuffer;
        this.k=k;
    }
    @Override
    public void undo() {
        textBuffer.insert(deleted);
    }

    @Override
    public void execute() {
       deleted= textBuffer.delete(k);
    }
}
