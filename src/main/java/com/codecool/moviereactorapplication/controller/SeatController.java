package com.codecool.moviereactorapplication.controller;

import com.codecool.moviereactorapplication.entity.Seat;
import com.codecool.moviereactorapplication.entity.SeatReserved;
import com.codecool.moviereactorapplication.repository.SeatRepository;
import com.codecool.moviereactorapplication.repository.SeatReservedRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class SeatController {
    private final SeatRepository seatRepository;
    private final SeatReservedRepository seatReservedRepository;

    public SeatController(SeatRepository seatRepository, SeatReservedRepository seatReservedRepository) {
        this.seatRepository = seatRepository;
        this.seatReservedRepository = seatReservedRepository;
    }

    @GetMapping("/seat/room/{id}")
    public List<Seat> getSeatByRoomId(@PathVariable("id") Long roomId) {
        return seatRepository.getSeatsByRoomId(roomId);
    }

    @GetMapping("/reserved-seats/show/{id}")
    public List<SeatReserved> getReservedSeatsByShowId(@PathVariable("id") Long showId)  {
        return seatReservedRepository.getReservedSeatsByShowId(showId);
    }
}
