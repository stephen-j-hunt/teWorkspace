package com.techelevator.auctions.services;

import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.auctions.model.Auction;

import java.util.HashMap;
import java.util.Map;

public class AuctionService {

    public static String API_BASE_URL = "http://localhost:3000/auctions/";
    private RestTemplate restTemplate = new RestTemplate();


    public Auction add(Auction newAuction) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Auction> payload = new HttpEntity<>(newAuction, headers);
        try {
            return this.restTemplate.postForObject(API_BASE_URL, payload, Auction.class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(String.format("%s:%s while adding a auction", e.getRawStatusCode(), e.getStatusText()));
        } catch (ResourceAccessException rae) {
            BasicLogger.log("unable to reach server");
        }

        return null;
    }

    public boolean update(Auction updatedAuction) {
        HttpEntity<Auction> payload = makeEntity(updatedAuction);
        boolean success= false;
        try {
            this.restTemplate.put(API_BASE_URL + updatedAuction.getId(), payload);
            success=true;
        } catch (RestClientResponseException e) {
            BasicLogger.log(String.format("%s:%s while updating an auction",e.getRawStatusCode(), e.getStatusText()));
        } catch (ResourceAccessException e) {
            BasicLogger.log("unable to reach server");
        }
        return success;

    }

    public boolean delete(int auctionId) {
        boolean success = false;
        try {
            restTemplate.delete(API_BASE_URL + auctionId);
            success = true;
        } catch (RestClientResponseException e) {
            BasicLogger.log(String.format("%s:%s while deleting an auction", e.getRawStatusCode(), e.getStatusText()));
        } catch (ResourceAccessException e) {
            BasicLogger.log("unable to reach server");
        }
        return success;
    }

public Auction[]getAllAuctions(){
        Auction[]auctions=null;
        try{
        auctions=restTemplate.getForObject(API_BASE_URL,Auction[].class);
        }catch(RestClientResponseException e){
        BasicLogger.log(e.getRawStatusCode()+" : "+e.getStatusText());
        }catch(ResourceAccessException e){
        BasicLogger.log(e.getMessage());
        }
        return auctions;
        }

public Auction getAuction(int id){
        Auction auction=null;
        try{
        auction=restTemplate.getForObject(API_BASE_URL+id,Auction.class);
        }catch(RestClientResponseException e){
        BasicLogger.log(e.getRawStatusCode()+" : "+e.getStatusText());
        }catch(ResourceAccessException e){
        BasicLogger.log(e.getMessage());
        }
        return auction;
        }

public Auction[]getAuctionsMatchingTitle(String title){
        Auction[]auctions=null;
        try{
        auctions=restTemplate.getForObject(API_BASE_URL+"?title_like="+title,Auction[].class);
        }catch(RestClientResponseException e){
        BasicLogger.log(e.getRawStatusCode()+" : "+e.getStatusText());
        }catch(ResourceAccessException e){
        BasicLogger.log(e.getMessage());
        }
        return auctions;
        }

public Auction[]getAuctionsAtOrBelowPrice(double price){
        Auction[]auctions=null;
        try{
        auctions=restTemplate.getForObject(API_BASE_URL+"?currentBid_lte="+price,Auction[].class);
        }catch(RestClientResponseException e){
        BasicLogger.log(e.getRawStatusCode()+" : "+e.getStatusText());
        }catch(ResourceAccessException e){
        BasicLogger.log(e.getMessage());
        }
        return auctions;
        }

private HttpEntity<Auction> makeEntity(Auction auction){
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(auction,headers);
        }

        }
