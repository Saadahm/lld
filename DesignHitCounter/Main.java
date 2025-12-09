package DesignHitCounter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hitter hitter=new Hitter(5);
        hitter.visitPage(1);
        hitter.visitPage(1);
        hitter.visitPage(0);
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter page index");
        int id=scanner.nextInt();
        System.out.println("Number of hits are: " + hitter.getHits(id));
    }
}
