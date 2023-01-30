package com.techelevator;

public class ReserveAuction extends Auction {

    private int reservePrice;

    public ReserveAuction(String item, int reserve) {
        super(item); // delegate to the constructor in the superclass
        this.reservePrice = reserve;
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
        if (offeredBid.getBidAmount() < reservePrice) {
            return false;
        }

        return super.placeBid(offeredBid);
    }
}
