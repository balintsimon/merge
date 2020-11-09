package com.codecool.moviereactorapplication.controller;

import com.codecool.moviereactorapplication.entity.SeatReservedWrapper;
import com.codecool.moviereactorapplication.model.SeatReservedWithDetails;
import com.codecool.moviereactorapplication.repository.SeatReservedRepository;
import com.codecool.moviereactorapplication.service.SeatReservedOrganiser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/reservation")
@Slf4j
public class ReservationController {

    private final SeatReservedOrganiser seatReservedOrganiser;

    private final SeatReservedRepository seatReservedRepository;

    public ReservationController(SeatReservedOrganiser seatReservedOrganiser, SeatReservedRepository seatReservedRepository) {
        this.seatReservedOrganiser = seatReservedOrganiser;
        this.seatReservedRepository = seatReservedRepository;
    }

    @Transactional
    @PostMapping(value = "/seats")
    public boolean saveReservedSeat(@RequestBody SeatReservedWrapper reservationInfoWrapper) throws IllegalStateException {
        return seatReservedOrganiser.saveReservedSeat(reservationInfoWrapper);
    }

    @DeleteMapping("/delete")
    // TODO: Only for admin and user too!
    public boolean deleteReservation(@RequestBody SeatReservedWrapper seats) {
        Long seatId = seats.getSeats().size() == 1 ? seats.getSeats().get(0) : null;
        if (seatId != null) {
            seatReservedRepository.deleteById(seatId);
            return true;
        }

        return false;
    }

    @GetMapping("/seats")
    // TODO: Only for admin, user should reach only user's seats!
    public List<SeatReservedWithDetails> getAllReservedSeats() {
        return seatReservedRepository.getAllReservationsWithDetails();
    }

}
