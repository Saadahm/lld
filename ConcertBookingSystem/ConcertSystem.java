package ConcertBookingSystem;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcertSystem {
    private static ConcertSystem instance;
    private ConcertSystem(){

    }
    public synchronized static ConcertSystem getInstance()
    {
        if(instance==null)
            instance=new ConcertSystem();
        return instance;
    }

    private Map<String, Concert>concerts=new HashMap<>();
    private PaymentStrategy paymentStrategy;
    private final Map<String, Booking> bookings=new HashMap<>();
    private final Object lock = new Object();
    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy=paymentStrategy;
    }


    public void bookConcert(Concert toBook, List<Seat> seatsToBook)
    {
        String artist=toBook.getArtist();
        LocalDateTime startTime = toBook.getStartTime();
        LocalDateTime endTime= toBook.getEndTime();
        String venue=toBook.getVenue();
Concert cur;
        for(Concert c: concerts.values()){
            if((c.getArtist().equals(artist)) && (c.getStartTime().isBefore(startTime)) && (c.getEndTime().isAfter(endTime)) &&
                  venue.equals(c.getVenue())){
                cur=c;
                Payment payment=new Payment(paymentStrategy);
                payment.pay();
                break;
            }
        }
        synchronized (lock)
        {
            for(Seat s: seatsToBook)
            {
                if(s.getStatus()!=SeatStatus.AVAILABLE){
                    break;
                }
            }
            for(Seat s: seatsToBook)
                s.book();

        }
        System.out.println("No concert ");
    }

    public void addConcert(Concert concert){
        concerts.put(concert.getId(), concert);
    }
}

