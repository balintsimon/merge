package com.codecool.moviereactorapplication.service;

import com.codecool.moviereactorapplication.entity.Room;
import com.codecool.moviereactorapplication.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class DataProvider implements CommandLineRunner {

    private final RoomCreator roomCreator;
    private final MovieCreator movieCreator;
    private final SeatCreator seatCreator;
    private final ShowCreator showCreator;
    private final SeatReservedCreator seatReservedCreator;

    private final RoomRepository roomRepository;

    private VisitorCreator visitorCreator;

    List<Integer> movieIds = Arrays.asList(496243, 495764, 475557, 155, 501907);

    public DataProvider(RoomCreator roomCreator, MovieCreator movieCreator, SeatCreator seatCreator, ShowCreator showCreator,
                        SeatReservedCreator seatReservedCreator, RoomRepository roomRepository, VisitorCreator visitorCreator) {
        this.roomCreator = roomCreator;
        this.movieCreator = movieCreator;
        this.seatCreator = seatCreator;
        this.showCreator = showCreator;
        this.seatReservedCreator = seatReservedCreator;
        this.roomRepository = roomRepository;
        this.visitorCreator = visitorCreator;
    }

    @Override
    public void run(String... args) {
        roomCreator.createNumberedRooms(1);

        movieCreator.createNumberedUniqueMoviesByIdsData(movieIds, 5);
        List<Room> rooms = roomRepository.findAll();
        for (Room room : rooms) {
            seatCreator.createSeatsForRoomData(room);
        }
        showCreator.createWeeklyScheduleData(LocalDate.of(2020, 7, 30));
        seatReservedCreator.createReservedSeatsData();

        visitorCreator.createAdmin();
        visitorCreator.createUser();
    }
}
