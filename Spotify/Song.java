package Spotify;

import java.util.UUID;

public class Song {
    private String id;
    private String name;
    public Song(String name)
    {
        this.id=UUID.randomUUID().toString();
        this.name=name;
    }
}
