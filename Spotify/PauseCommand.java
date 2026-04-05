package Spotify;

public class PauseCommand {
    private Player player;
    public PauseCommand(Player player)
    {
        this.player=player;
    }
    public void execute()
    {
        player.pause();
    }
}
