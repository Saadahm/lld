package DocumentEditor;

public class Main {
    public static void main(String[] args) {
        Document document= new Document();
        ImageElement imageElement= new ImageElement("Image1");
        TextElement textElement= new TextElement("Text1");
        document.addDocument(imageElement);
        System.out.println(imageElement.render());
        document.addDocument(textElement);
        System.out.println(document.render());
    }
}
