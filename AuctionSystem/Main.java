package AuctionSystem;

public class Main {
    public static void main(String[] args) {
        AuctionService auctionService=AuctionService.getInstance();
        User user= new User("User1");
        User user1=new User("User2");
        auctionService.addUser(user);
        Item item=new Item("Table",20);
        Auction auction= new Auction(item);
        Bid bid=new Bid(user,10);
        Bid bid1=new Bid(user1,15);
        auctionService.placeBid(auction,item,bid);
        auctionService.placeBid(auction,item,bid1);
        System.out.println(auctionService.getWinner(auction));
    }
}
