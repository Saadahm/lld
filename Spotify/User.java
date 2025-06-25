package Spotify;

import java.util.List;
import java.util.UUID;

public class User {
    private String id;
    private String username;
    private String password;
    private List<Playlist> playlists;

    public User(String username, String password) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
    }
}
