package com.techelevator;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        placeBid(generalAuction, new Bid("Josh", 1));
        placeBid(generalAuction, new Bid("Fonz", 23));
        placeBid(generalAuction, new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids

        ReserveAuction reserveAuction = new ReserveAuction("coffee mug, 10");


    }


    public static void placeBid(Auction auction, Bid bid) {
        boolean isWinning  = auction.placeBid(bid);
        // mike bid $$$ on xxx. currently winning? xxx
        System.out.printf("%s bid %s on %s. currently winning? %s\n", bid.getBidder(),
                bid.getBidAmount(),
                auction.getItemForSale(),
                isWinning);
    }
}
