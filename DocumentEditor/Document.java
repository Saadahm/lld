package DocumentEditor;

import java.util.ArrayList;
import java.util.List;

public class Document {
    private List<DocumentElement> documentList;
    public Document(){
        this.documentList=new ArrayList<>();
    }
    public void addDocument(DocumentElement documentElement){
        documentList.add(documentElement);
    }
    public String render() {
        StringBuilder result = new StringBuilder();
        for (DocumentElement element : documentList) {
            result.append(element.render());
        }
        return result.toString();
    }
}
