package com.codecool.moviereactorapplication.service;

import com.codecool.moviereactorapplication.entity.Seat;
import com.codecool.moviereactorapplication.entity.SeatReserved;
import com.codecool.moviereactorapplication.entity.Show;
import com.codecool.moviereactorapplication.repository.SeatRepository;
import com.codecool.moviereactorapplication.repository.SeatReservedRepository;
import com.codecool.moviereactorapplication.repository.ShowRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class SeatReservedCreator {

    private final SeatReservedRepository seatReservedRepository;
    private final ShowRepository showRepository;
    private final SeatRepository seatRepository;

    private final Random random = new Random();

    public SeatReservedCreator(SeatReservedRepository seatReservedRepository,
                               ShowRepository showRepository,
                               SeatRepository seatRepository) {
        this.seatReservedRepository = seatReservedRepository;
        this.showRepository = showRepository;
        this.seatRepository = seatRepository;
    }

    public void createReservedSeatsData() {
        for (Show show : showRepository.findAll()) {
            Long roomId = show.getRoom().getId();
            List<Seat> seats = seatRepository.getSeatsByRoomId(roomId);

            for (Seat seat : seats) {
                if (random.nextBoolean()) {
                    SeatReserved currentSeat = SeatReserved.builder()
                            .seat(seat)
                            .show(show)
                            .build();
                    seatReservedRepository.save(currentSeat);
                }
            }
        }
    }
}
