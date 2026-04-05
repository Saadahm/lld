package Spotify;

import Spotify.states.PauseState;
import Spotify.states.PlayState;
import Spotify.states.State;

public class Player {
    private State state;
    public Player()
    {
        this.state=new PlayState(this);
    }

    public void setState(State state) {
        this.state = state;
    }
    public void play()
    {
        state.play();
    }
    public void pause()
    {
        state.pause();
    }
}
