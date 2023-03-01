package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    public HotelController() {
        this.hotelDao = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> listHotels(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String state) {

        if (state != null || city != null) {
            return this.hotelDao.getFilteredList(state, city);
        } else {
            return hotelDao.list();
        }

    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel getHotelById(@PathVariable int id) { // parameter matches the token in the path template
        return hotelDao.get(id);
    }

    @GetMapping("/reservations")
    public List<Reservation> getReservations() {
        return this.reservationDao.findAll();
    }

    // GET http://localhost/reservations/42
    @GetMapping("/reservations/{id}")
    public Reservation getReservationsById(@PathVariable("id") int reservationId) {
        return this.reservationDao.get(reservationId);
    }

    @GetMapping("/hotels/{id}/reservations")
    public List<Reservation> getReservationsForHotel(@PathVariable int id) {
        return this.reservationDao.findByHotel(id);
    }


    @PostMapping("/reservations")
    public Reservation addReservation(@RequestBody Reservation newReservation) {
        return this.reservationDao.create(newReservation, newReservation.getHotelId());
    }

}
