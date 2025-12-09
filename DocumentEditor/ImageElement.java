package DocumentEditor;

public class ImageElement extends DocumentElement{
    public ImageElement(String content){
        super(content);
    }
    @Override
    public String render(){
        return content;
    }
}
