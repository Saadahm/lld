package TextEditorLLD;

import java.util.ArrayList;

public class TextRow {
    private ArrayList<Flyweight> data=new ArrayList<>();
    public void addCharacter(Flyweight flyweight, int column){
        data.add(flyweight);
        int current=data.size()-1;
        while(current>0 && current>column){
            Flyweight temp=data.get(current-1);
            data.set(current-1, data.get(current));
            data.set(current, temp);
            current--;
        }
    }
    public void read(){
        for(Flyweight f: data){
            System.out.println(f.getCur());
        }
    }
}
