package AuctionSystem;

import DigitalWalletDesign.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class AuctionService {
    private Map<String,Auction> auctions=new ConcurrentHashMap<>();
    public static AuctionService instance;
    private List<User> users=new ArrayList<>();
    private Object lock=new ReentrantLock();
    public AuctionService(){}
    public static AuctionService getInstance(){
        if(instance==null)
        {
            synchronized (AuctionService.class){
                instance=new AuctionService();
            }
        }
        return instance;
    }
    public void addAuction(Auction auction)
    {
        auctions.put(auction.getId(), auction);
    }
    public User getWinner(Auction auction)
    {
        System.out.println("winning amount "+ auction.getMaxBid().getAmount());
        return auction.getMaxBid().getUser();
    }
    public void addUser(User user)
    {
        users.add(user);
    }
    public void placeBid(Auction auction, Item item, Bid bid)
    {
        synchronized (lock)
        {
            if(auction.getMaxBid()==null)
            {
                auction.setMaxBid(bid);
                auction.addBid(bid);
                for(User user: users)
                user.update("Bid placed");
                return;
            }
            Bid maxBid = auction.getMaxBid();
            int maxAmount = maxBid.getAmount();
            auction.addBid(bid);
            if (bid.getAmount() > maxAmount) {
                auction.setMaxBid(bid);
            }
            for(User user: users)
                user.update("Bid placed");
        }

    }
}
