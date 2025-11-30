package SnakeandLadder;

public class Snake {
    private int startx;
    private int starty;
    private int endx;
    private int endy;
    public Snake(int startx, int starty, int endx, int endy){
        this.startx=startx;
        this.endx=endx;
        this.starty=starty;
        this.endy=endy;
    }
    public int getStartx() {
        return startx;
    }

    public int getEndx() {
        return endx;
    }

    public int getEndy() {
        return endy;
    }

    public int getStarty() {
        return starty;
    }
}
