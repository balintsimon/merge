package com.codecool.moviereactorapplication.repository;

import com.codecool.moviereactorapplication.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM Show s JOIN Movie m ON s.movie.id = m.id WHERE s.id = :show_id")
    Movie findMovieByShowId(@Param("show_id") Long show_id);

}
