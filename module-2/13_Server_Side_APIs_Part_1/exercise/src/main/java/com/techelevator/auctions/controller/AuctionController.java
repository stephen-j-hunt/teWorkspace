package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDao dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDao();
    }

    @GetMapping()
    public List<Auction> retrieveAuctions(
            @RequestParam(required = false, defaultValue = "") String title_like,
            @RequestParam(required = false, defaultValue = "0.0") double currentBid_lte) {

        if (!title_like.equals("") && currentBid_lte > 0) {
            return this.dao.searchByTitleAndPrice(title_like, currentBid_lte);
        }
        if (!title_like.equals("")) {
            return this.dao.searchByTitle(title_like);
        }
        if (currentBid_lte > 0) {
            return this.dao.searchByPrice(currentBid_lte);

        } else {
            return dao.list();
        }
    }

    @GetMapping("/{id}")
    public Auction retrieveAuctionById(@PathVariable int id) {
        return dao.get(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Auction create(@RequestBody Auction auction) {
        if (auction != null) {
            auction.setId(auction.getId());
            return dao.create(auction);
        }
        return dao.create(auction);

    }
}
