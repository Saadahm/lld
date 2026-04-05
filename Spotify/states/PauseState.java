package Spotify.states;

import Spotify.Player;

public class PauseState extends State{
    public PauseState(Player player)
    {
        super(player);
    }
    public void play()
    {
        player.setState(new PlayState(player));
        System.out.println("Song played");
    }
    @Override
    public void pause(){
        System.out.println("Player already paused");
    }
}
