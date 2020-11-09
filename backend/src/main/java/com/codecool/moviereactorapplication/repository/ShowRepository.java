package com.codecool.moviereactorapplication.repository;

import com.codecool.moviereactorapplication.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    Show getShowById(Long showId);

    @Query(value="SELECT show FROM Show show " +
            "JOIN Movie movie ON movie = show.movie " +
            "WHERE show.id = :showId "
            )
    Show getShowAndJoinWithInfo(@Param("showId") Long id);
}
