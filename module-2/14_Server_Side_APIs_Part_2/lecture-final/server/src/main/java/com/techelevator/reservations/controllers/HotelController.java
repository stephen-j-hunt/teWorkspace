package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    public HotelController(HotelDao hotelDao, ReservationDao reservationDao) {
        this.hotelDao = hotelDao;
        this.reservationDao = reservationDao;
    }

    /**
     * /hotels
     * /hotels?state=ohio
     * /hotels?state=ohio&city=cleveland
     *
     * @param state the state to filter by
     * @param city  the city to filter by
     * @return a list of hotels that match the city & state
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> filterByStateAndCity(@RequestParam(required = false) String state, @RequestParam(required = false) String city) {
        return hotelDao.getFilteredList(state, city);
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) {
        Hotel hotel = hotelDao.get(id);
        if (hotel == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unknown hotel");
        }
        return hotel;
    }

    /**
     * Returns all reservations in the system
     *
     * @return all reservations
     */
    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<Reservation> listReservations() {
        return reservationDao.findAll();
    }

    /**
     * Get a reservation by its id
     *
     * @param id
     * @return a single reservation
     */
    @RequestMapping(path = "reservations/{id}", method = RequestMethod.GET)
    public Reservation getReservation(@PathVariable int id) {
        Reservation reservation = reservationDao.get(id);
        if (reservation == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "unknown reservation");
        }
        return reservation;
    }

    /**
     * List of reservations by hotel
     *
     * @param hotelId
     * @return all reservations for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}/reservations", method = RequestMethod.GET)
    public List<Reservation> listReservationsByHotel(@PathVariable("id") int hotelId) {
        Hotel hotel = this.hotelDao.get(hotelId);
        if (hotel == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "unknown hotel");
        }
        List<Reservation> reservations = reservationDao.findByHotel(hotelId);
        return reservations;
    }

    /**
     * Create a new reservation for a given hotel
     *
     * @param reservation
     */
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/reservations", method = RequestMethod.POST)
    public Reservation addReservation(@Valid @RequestBody Reservation reservation) {
        final int hotelId = reservation.getHotelId();
        if  (this.hotelDao.get(hotelId) == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unknown hotel");
        }
        return reservationDao.create(reservation, hotelId);
    }

    @PutMapping(path = "/reservations/{id}")
    public Reservation updateReservation(@Valid @RequestBody Reservation reservation, @PathVariable int id) {
       Reservation updatedReservation = this.reservationDao.update(reservation, id);
       if (updatedReservation == null) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "unknown reservation");
       }
       return updatedReservation;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/reservations/{id}")
    public void deleteReservation(@PathVariable int id) {
        Reservation reservation = this.reservationDao.get(id);
        if (reservation == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "unknown reservation");
        }
        this.reservationDao.delete(id);
    }

}
