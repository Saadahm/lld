package Spotify;

import java.time.Duration;
import java.util.UUID;

public class Song {
    private String id;
    private String name;
    private Artist artist;
    private Duration duration;
    private final Album album;

    public Song(String name, Artist artist, Duration duration, Album album) {
        this.id= UUID.randomUUID().toString();
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.duration=duration;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Artist getArtist() {
        return artist;
    }

    public String getArtistName() {
        return artist.getName();
    }

    public Album getAlbum() {
        return album;
    }
}
