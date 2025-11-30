package SnakeandLadder;

import java.util.HashMap;

public class Board {
    HashMap<Pair, Ladder>ladderHashMap= new HashMap<>();
    HashMap<Pair, Snake>snakeHashMap= new HashMap<>();
    private static Board instance;
    private Board(){

    }
    public static Board getInstance()
    {
        if(instance==null)
            instance=new Board();
        return instance;
    }
    public void initBoard(){
        Ladder l1 = new Ladder(1,2, 4,5);
        Ladder l2=new Ladder(3,4,6,7);
        Snake s1= new Snake(3,5, 6 ,8);
        ladderHashMap.put(new Pair(1,2), l1);
        ladderHashMap.put(new Pair(3,4), l2);
        snakeHashMap.put(new Pair(3,5), s1);
    }
    public void movePlayer(Player player, int value){
        // convert (x,y) -> linear pos in range 1..100
        int initialx = player.getXc();
        int initialy = player.getYc();
        int pos = (initialy - 1) * 10 + initialx; // e.g. (1,1) -> 1, (10,10) -> 100

        int newPos = pos + value;
        if (newPos > 100) {
            // overshoot: don't move the player
            return;
        }

        // convert back linear pos -> (x,y)
        int finalx = (newPos - 1) % 10 + 1;
        int finaly = (newPos - 1) / 10 + 1;

        Pair landing = new Pair(finalx, finaly);
        if (ladderHashMap.containsKey(landing)) {
            Ladder l = ladderHashMap.get(landing);
            player.setXc(l.getEndx());
            player.setYc(l.getEndy());

            Pair afterLadder = new Pair(player.getXc(), player.getYc());
            if (snakeHashMap.containsKey(afterLadder)) {
                Snake s = snakeHashMap.get(afterLadder);
                player.setXc(s.getEndx());
                player.setYc(s.getEndy());
            }
        } else if (snakeHashMap.containsKey(landing)) {
            Snake s = snakeHashMap.get(landing);
            player.setXc(s.getEndx());
            player.setYc(s.getEndy());
        } else {
            player.setXc(finalx);
            player.setYc(finaly);
        }
    }

}
