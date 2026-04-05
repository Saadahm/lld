package Spotify.states;

import Spotify.Player;

public class IdleState extends State {
    public IdleState(Player player)
    {
        super(player);
    }
    @Override
    public void play()
    {
        player.setState(new PlayState(player));
        System.out.println("Song played");
    }
    @Override
    public void pause(){

    }
}
