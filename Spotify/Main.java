package Spotify;

public class Main {
    public static void main(String[] args) {
        Remote remote=new Remote();
        Player player=new Player();
        remote.setCommand(new PlayCommand(player));
        remote.pressButton();
    }
}
