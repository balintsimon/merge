package com.codecool.moviereactorapplication.service;

import com.codecool.moviereactorapplication.entity.Movie;
import com.codecool.moviereactorapplication.entity.Show;
import com.codecool.moviereactorapplication.repository.MovieRepository;
import com.codecool.moviereactorapplication.repository.RoomRepository;
import com.codecool.moviereactorapplication.repository.SeatReservedRepository;
import com.codecool.moviereactorapplication.repository.ShowRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class ShowCreator {
    private final ShowRepository showRepository;
    private final RoomRepository roomRepository;
    private final MovieRepository movieRepository;
    private final SeatReservedRepository seatReservedRepository;

    public ShowCreator(ShowRepository showRepository, RoomRepository roomRepository, MovieRepository movieRepository, SeatReservedRepository seatReservedRepository) {
        this.showRepository = showRepository;
        this.roomRepository = roomRepository;
        this.movieRepository = movieRepository;
        this.seatReservedRepository = seatReservedRepository;
    }

    public void createWeeklyScheduleData(LocalDate fromDate) {
        for (int i = 0; i < 7; i++) {
            LocalTime startingTime = LocalTime.of(12, 0);
            for (Movie movie : movieRepository.findAll()) {
                Show currentShow = Show.builder()
                        .movie(movie)
                        .startingDate(fromDate)
                        .startingTime(startingTime)
                        .room(roomRepository.findAll().get(0))
                        .build();
                currentShow.setReservedSeats(seatReservedRepository.getReservedSeatsByShowId(currentShow.getId()));
                showRepository.save(currentShow);
                startingTime = startingTime.plusHours(2);
            }
            fromDate = fromDate.plusDays(1);
        }
    }
}
