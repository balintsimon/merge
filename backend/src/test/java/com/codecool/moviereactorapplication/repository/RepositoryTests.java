package com.codecool.moviereactorapplication.repository;

import com.codecool.moviereactorapplication.entity.Movie;
import com.codecool.moviereactorapplication.entity.Show;
import com.codecool.moviereactorapplication.model.MovieType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class RepositoryTests {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private SeatReservedRepository seatReservedRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void saveOneMovie() {
        Movie movie = Movie.builder()
                .movieDbId(495467)
                .movieType(MovieType.HU2D)
                .build();
        movieRepository.save(movie);
        List<Movie> movies = movieRepository.findAll();
        assertThat(movies).hasSize(1);
    }

    @Test
    public void showIsPersistentWithMovie() {
        LocalDate date = LocalDate.now();
        LocalTime startingTime = LocalTime.NOON;
        Show show = Show.builder()
                .startingDate(date)
                .startingTime(startingTime)
                .build();
        List<Show> shows = new ArrayList<>();
        shows.add(show);
        Movie movie = Movie.builder()
                .movieDbId(111)
                .movieType(MovieType.OV3D)
                .shows(shows)
                .build();
        movieRepository.save(movie);
        List<Show> dbShows = showRepository.findAll();
                assertThat(dbShows)
                .hasSize(1)
                .allMatch(show1 -> show1.getId() > 0L);
    }

    @Test
    public void findMovieByShow() {
        Movie movie = Movie.builder()
                .movieDbId(475557)
                .movieType(MovieType.HU2D)
                .build();
        LocalDate date = LocalDate.now();
        LocalTime startingTime = LocalTime.NOON;
        Show show = Show.builder()
                .startingDate(date)
                .startingTime(startingTime)
                .movie(movie)
                .build();
        showRepository.save(show);
        movieRepository.saveAndFlush(movie);

        Movie movieByClient = movieRepository.findMovieByShowId(show.getId());
        assertEquals(movie, movieByClient);
    }

    @Test
    public void showIsDeletedWithMovie() {
        Movie movie = Movie.builder()
                .movieDbId(155)
                .movieType(MovieType.SUB2D)
                .build();
        LocalDate date = LocalDate.now();
        LocalTime startingTime = LocalTime.NOON;
        Show show = Show.builder()
                .startingDate(date)
                .startingTime(startingTime)
                .movie(movie)
                .build();
        movieRepository.save(movie);
        showRepository.save(show);
        entityManager.clear();
        movieRepository.deleteAll();
        assertThat(showRepository.findAll()).hasSize(0);
    }

}
