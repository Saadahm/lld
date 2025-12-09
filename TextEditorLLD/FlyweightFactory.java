package TextEditorLLD;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    Map<String,Flyweight>map=new HashMap<>();
    public Flyweight createStyle(char ch, String font){
        StringBuilder s= new StringBuilder();
        s.append(ch);
        s.append(font);
        if(!map.containsKey(s.toString()))
            map.put(s.toString(),new Flyweight(ch,font));
        return map.get(s.toString());
    }
}
