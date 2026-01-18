package AuctionSystem;

import java.util.ArrayList;
import java.util.List;

public class Auction {
    private String id;
    private List<Bid>bids= new ArrayList<>();
    private Bid maxBid;
    private Item item;
    public Auction(Item item)
    {
        this.item=item;
        maxBid=null;
    }
    public void addBid(Bid bid)
    {
        bids.add(bid);
    }
    public String getId() {
        return id;
    }

    public Bid getMaxBid() {
        return maxBid;
    }
    public void setMaxBid(Bid maxBid)
    {
        this.maxBid=maxBid;
    }
}
