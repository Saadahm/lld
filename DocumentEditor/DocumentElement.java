package DocumentEditor;

public abstract class DocumentElement {
    protected String content;
    public DocumentElement(String content){
        this.content=content;
    }
    public abstract String render();
}
