package DesignHitCounter;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Hitter {
    private int totalPages;
//    private int []a;
    private ArrayList<AtomicInteger>a= new ArrayList<>();
    public Hitter(int totalPages){
        this.totalPages=totalPages;
        for(int i=0;i<totalPages;i++)
            a.add(new AtomicInteger(0));
    }
    public int getHits(int index)
    {
       return a.get(index).get();
    }
    public void visitPage(int index){
       a.get(index).incrementAndGet();
    }
}
