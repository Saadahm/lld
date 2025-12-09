package ConcertBookingSystem;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Concert {
    private String id;
    private String venue;
    private String artist;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<Seat> seats;
    public Concert(String venue, String artist, LocalDateTime startTime, LocalDateTime endTime,List<Seat> seats){
        this.id= UUID.randomUUID().toString();
        this.venue=venue;
        this.artist=artist;
        this.startTime=startTime;
        this.endTime=endTime;
        this.seats=seats;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getVenue() {
        return venue;
    }

    public String getArtist() {
        return artist;
    }
}
