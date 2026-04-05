package TextEditorCommand;

import java.util.ArrayDeque;
import java.util.Deque;

public class TextEditor {
    private TextBuffer textBuffer;
    private final Deque<Command> undoStack = new ArrayDeque<>();

    public TextEditor() {
        textBuffer = new TextBuffer();
    }

    public void insert(String s) {
        Command command = new InsertCommand(textBuffer, s);
        command.execute();
        undoStack.push(command);
    }

    public void undo() {
        Command c = undoStack.pop();
        c.undo();
    }

    public String text() {
        return textBuffer.text();
    }
}
