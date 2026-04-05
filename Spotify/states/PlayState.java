package Spotify.states;

import Spotify.Player;

public class PlayState extends State{
    public PlayState(Player player)
    {
        super(player);
    }
    @Override
    public void play()
    {
        System.out.println("Player already playing");
    }
    @Override
    public void pause(){
        player.setState(new PauseState(player));
        System.out.println("Song paused");
    }
}
