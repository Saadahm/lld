package SnakeandLadder;

public class Player {
    private int xc;
    private int yc;
    public Player(int xc, int yc){
        this.xc=xc;
        this.yc=yc;
    }

    public int getXc() {
        return xc;
    }

    public int getYc() {
        return yc;
    }

    public void setXc(int xc) {
        this.xc = xc;
    }

    public void setYc(int yc) {
        this.yc = yc;
    }
}
