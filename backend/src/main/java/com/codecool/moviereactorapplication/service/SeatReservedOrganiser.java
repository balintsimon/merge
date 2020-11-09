package com.codecool.moviereactorapplication.service;

import com.codecool.moviereactorapplication.entity.Seat;
import com.codecool.moviereactorapplication.entity.SeatReserved;
import com.codecool.moviereactorapplication.entity.SeatReservedWrapper;
import com.codecool.moviereactorapplication.entity.Show;
import com.codecool.moviereactorapplication.repository.SeatRepository;
import com.codecool.moviereactorapplication.repository.SeatReservedRepository;
import com.codecool.moviereactorapplication.repository.ShowRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeatReservedOrganiser {
    private final ShowRepository showRepository;
    private final SeatRepository seatRepository;
    private final SeatReservedRepository seatReservedRepository;

    public SeatReservedOrganiser(ShowRepository showRepository, SeatRepository seatRepository, SeatReservedRepository seatReservedRepository) {
        this.showRepository = showRepository;
        this.seatRepository = seatRepository;
        this.seatReservedRepository = seatReservedRepository;
    }

    public boolean saveReservedSeat(SeatReservedWrapper reservationInfo)
            throws IllegalStateException {
        Long showId = reservationInfo.getId();

        Show actualShow = showRepository.getShowById(showId);
        if (actualShow == null) {
            throw new IllegalStateException("Show not found.");
        }

        List<Long> seatIds = reservationInfo.getSeats();
        if (seatIds.size() == 0) {
            return false;
        }

        for (Long actualSeatId : seatIds) {
            Seat actualSeat = seatRepository.getById(actualSeatId);
            if (actualSeat == null) {
                throw new IllegalStateException("Seat not found.");
            }

            SeatReserved foundSeat = seatReservedRepository.getSeatReservedBySeatAndShow(actualSeat, actualShow);
            if (foundSeat != null) {
                return false;
                // NB: throwing exception crashes frontend unbeknownst to the user; bad user experience
//                    throw new IllegalStateException("Seat has been already taken.");
            }
        }

        for (Long actualSeatId : seatIds) {
            Seat actualSeat = seatRepository.getById(actualSeatId);
            SeatReserved newSeatReserved = SeatReserved.builder()
                    .seat(actualSeat)
                    .show(actualShow)
                    .build();
            seatReservedRepository.save(newSeatReserved);
        }
        return true;
    }
}
