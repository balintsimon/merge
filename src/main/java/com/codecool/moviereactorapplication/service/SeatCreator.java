package com.codecool.moviereactorapplication.service;

import com.codecool.moviereactorapplication.entity.Room;
import com.codecool.moviereactorapplication.entity.Seat;
import com.codecool.moviereactorapplication.repository.SeatRepository;
import org.springframework.stereotype.Component;

@Component
public class SeatCreator {
    private final SeatRepository seatRepository;

    public SeatCreator(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public void createSeatsForRoomData(Room room) {
        for (int row = 1; row < room.getNumberOfRows() + 1; row++) {
            for (int seatNumber = 1; seatNumber < room.getNumberOfSeatsPerRow() + 1; seatNumber++) {
                Seat newSeat = Seat.builder()
                        .rowNumber(row)
                        .seatNumber(seatNumber)
                        .room(room)
                        .build();
                seatRepository.save(newSeat);
            }
        }
    }
}