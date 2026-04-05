package TextEditorCommand;

public class Main {
    public static void main(String[] args) {
        TextEditor t=new TextEditor();
        t.insert("Hello");
        t.insert("Op");
        System.out.println(t.text());
        t.undo();
        System.out.println(t.text());
    }
}
