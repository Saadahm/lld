package Spotify;

public class PlayCommand implements Command{
    private Player player;
    public PlayCommand(Player player)
    {
        this.player=player;
    }
    public void execute()
    {
        player.play();
    }
}
