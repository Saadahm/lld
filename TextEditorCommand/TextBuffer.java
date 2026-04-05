package TextEditorCommand;

import java.util.ArrayDeque;
import java.util.Deque;

public class TextBuffer {
    private String s;
    private Deque<Character> left=new ArrayDeque<>();
    private Deque<Character>right=new ArrayDeque<>();
    public void insert(String s)
    {
        for(char c: s.toCharArray()){
            left.addLast(c);
        }

    }
    public String delete(int k)
    {
        StringBuilder sb=new StringBuilder();
        while(k>0 && !left.isEmpty())
        {
            char c=left.getLast();
            left.removeLast();
            sb.append(c);
        }
        return sb.toString();
    }
    public String text()
    {
        StringBuilder sb=new StringBuilder();
        for(char c: left)sb.append(c);
        return sb.toString();
    }
}
