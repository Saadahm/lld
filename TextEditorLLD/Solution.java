package TextEditorLLD;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<TextRow>rows=new ArrayList<>();
    public void addCharacter(int row, int col, char ch, String fontName){
        FlyweightFactory flyweightFactory= new FlyweightFactory();
        if(row>=rows.size())
            rows.add(new TextRow());
        TextRow r= rows.get(row);
        Flyweight f=flyweightFactory.createStyle(ch, fontName);
        r.addCharacter(f,col);
    }
    public void readLine(int row){
        TextRow r= rows.get(row);
        r.read();
    }
}
