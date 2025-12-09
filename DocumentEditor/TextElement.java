package DocumentEditor;

public class TextElement extends DocumentElement{
    public TextElement(String content){
        super(content);
    }
    @Override
    public String render(){
        return content;
    }
}
