package SnakeandLadder;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board=Board.getInstance();
        Player p1=new Player(1,1);
        Player p2= new Player(1,1);
        board.initBoard();
        Scanner scanner=new Scanner(System.in);
        int flag=0;
        while(true){

            if(flag==0)
            {
                System.out.println("Player 1 your turn");
                Random rand = new Random();
                int dice=rand.nextInt(6)+1;
                System.out.println("Dice showed" + dice);
                board.movePlayer(p1,dice);
                if(p1.getXc()==10 && p1.getYc()==10){
                    System.out.println("Player 1 wins");
                    break;
                }
                else {
                    System.out.println("Player 1 coordinates are ["+p1.getXc()+" "+p1.getYc()+"]");
                }
            }
            else {
                System.out.println("Player 2 your turn");
                Random rand = new Random();
                int dice=rand.nextInt(6)+1;
                System.out.println("Dice showed" + dice);
                board.movePlayer(p2,dice);
                if(p2.getXc()==10 && p2.getYc()==10){
                    System.out.println("Player 2 wins");
                    break;
                }
                else{
                    System.out.println("Player 2 coordinates are ["+p2.getXc()+" "+p2.getYc()+"]");
                }
            }

            flag^=1;

        }
    }
}
