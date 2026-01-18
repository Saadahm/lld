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


    public void bookConcert(Concert toBook, List<Seat> seatsToBook, User user)
    {
        Concert concertToBook = concerts.get(toBook.getId());
        if(concertToBook == null) {
            System.out.println("Concert not found");
            return;
        }

        synchronized (lock)
        {
            for(Seat s: seatsToBook)
            {
                if(s.getStatus()!=SeatStatus.AVAILABLE){
                    System.out.println("Seats not available");
                    return;
                }
            }

            for(Seat s: seatsToBook)
                s.book();

            if(paymentStrategy != null) {
                Payment payment=new Payment(paymentStrategy);
                payment.pay();
            }

            String bookingId = "BK" + System.currentTimeMillis();
            Booking booking = new Booking(bookingId, user, concertToBook, seatsToBook);
            bookings.put(bookingId, booking);

            System.out.println("Booking successful! Booking ID: " + bookingId);
        }
    }

    public void addConcert(Concert concert){
        concerts.put(concert.getId(), concert);
    }
}

