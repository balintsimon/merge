package com.codecool.moviereactorapplication.controller;

import com.codecool.moviereactorapplication.entity.Movie;
import com.codecool.moviereactorapplication.model.MovieType;
import com.codecool.moviereactorapplication.repository.MovieRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DataJpaTest
class MovieControllerTest {
    @Autowired
    private MovieRepository movieRepository;

    MovieController movieController;

    @BeforeEach
    void initialize() {
        movieController = new MovieController(movieRepository);
    }

    @Test
    void testOneMovieIsScheduled() {
        Movie movie = Movie.builder()
                .movieDbId(1122)
                .movieType(MovieType.HU2D)
                .build();
        movieRepository.save(movie);

        assertThat(movieRepository.findAll()).hasSize(1);
        assertEquals(movieRepository.findAll(), movieController.getAllScheduledMovie());
    }

    @Test
    void testZeroMovieIsScheduled() {
        assertThat(movieRepository.findAll()).hasSize(0);
        assertEquals(movieRepository.findAll(), movieController.getAllScheduledMovie());
    }

    @Test
    void testMultipleMoviesAreScheduled() {
        for (int i = 0; i < 10; i++) {
            Movie movie = Movie.builder()
                    .movieDbId(1122)
                    .movieType(MovieType.HU2D)
                    .build();
            movieRepository.save(movie);
        }

        assertThat(movieRepository.findAll()).hasSize(10);
        assertEquals(movieRepository.findAll(), movieController.getAllScheduledMovie());
    }


    @Test
    void testValidInputThenReturns200StatusCode() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new MovieController(this.movieRepository)).build();
        mockMvc.perform(MockMvcRequestBuilders
                .get("/scheduled-movies")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testValidInputForPostThenReturns4xxStatusCode() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new MovieController(this.movieRepository)).build();
        mockMvc.perform(MockMvcRequestBuilders
                .post("/scheduled-movies")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}