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
        if (state != null && city != null) {
            return hotelDao.getFilteredList(state, city);
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
    public Hotel get(@PathVariable int id) {
        return hotelDao.get(id);
    }
    @GetMapping("/reservations")
    public List<Reservation> getReservations() {
        return reservationDao.findAll();
    }
    @GetMapping("/reservations/{id}")
    public Reservation getReservationById(@PathVariable int id) {
        return reservationDao.get(id);
    }
@GetMapping("/hotels/{id}/reservations")
    public List<Reservation> getHotelReservation(@PathVariable int id) {
        return reservationDao.findByHotel(id);
}
@PostMapping("/reservations")
    public Reservation createReservation(@RequestBody Reservation newReservation) {
        return reservationDao.create(newReservation, newReservation.getHotelId());
}

}
