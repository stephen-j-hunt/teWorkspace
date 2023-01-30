package com.techelevator;

public class BuyNowAuction extends Auction {

    private final int price;

    public BuyNowAuction(String item, int price) {
        super(item);
        this.price = price;
    }

    public boolean placeBid(Bid offeredBid) {
        if (isSold()) {
            return false;
        }

        Bid bid = offeredBid;
        if (bid.getBidAmount() >= price) {
            bid = new Bid(bid.getBidder(), price);
        }
        return super.placeBid(bid);
    }

    private boolean isSold() {
        Bid currentHighBid = this.getHighBid();
        return (currentHighBid.getBidAmount() >= price);
    }

}
