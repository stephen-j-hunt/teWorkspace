package com.techelevator.hotels.services;

import com.techelevator.hotels.model.City;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import org.springframework.web.client.RestTemplate;

public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000/";
    private final RestTemplate restTemplate = new RestTemplate();

    public Hotel[] listHotels() {
        // http://localhost:3000/hotels
        return this.restTemplate.getForObject(API_BASE_URL+"hotels",Hotel[].class);
    }

    public Review[] listReviews() {
        return this.restTemplate.getForObject(API_BASE_URL+"reviews", Review[].class);
    }

    public Hotel getHotelById(int id) {
        // http://localhost:3000/hotels/1
        return this.restTemplate.getForObject(API_BASE_URL+"hotels/"+id, Hotel.class);
    }

    public Review[] getReviewsByHotelId(int hotelId) {
        // http://localhost:3000/hotels/1/reviews
        return this.restTemplate.getForObject(API_BASE_URL+"hotels/"+hotelId+"/reviews", Review[].class);
    }

    public Hotel[] getHotelsByStarRating(int stars) {
        // http://localhost:3000/hotels?stars=3
        return this.restTemplate.getForObject(API_BASE_URL+"hotels?stars="+stars, Hotel[].class);
    }

    public City getWithCustomQuery(){
        return null;
    }

}
