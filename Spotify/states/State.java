package Spotify.states;

import Spotify.Player;

public abstract class State {
    protected Player player;
    public State(Player player)
    {
        this.player=player;
    }
    public abstract void play();
    public abstract void pause();
}
