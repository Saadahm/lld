package TextEditorLLD;

public class Flyweight {
    private char ch;
    private String fontName;

    public Flyweight(char ch, String fontName){
        this.ch=ch;
        this.fontName=fontName;
    }
    public String getCur(){
        StringBuilder s= new StringBuilder();
        s.append(ch);
        s.append(fontName);
        return s.toString();
    }
}
