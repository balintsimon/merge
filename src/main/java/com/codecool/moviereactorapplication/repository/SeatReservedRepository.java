package com.codecool.moviereactorapplication.repository;

import com.codecool.moviereactorapplication.entity.Seat;
import com.codecool.moviereactorapplication.entity.SeatReserved;
import com.codecool.moviereactorapplication.model.SeatReservedWithDetails;
import com.codecool.moviereactorapplication.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatReservedRepository extends JpaRepository<SeatReserved, Long> {
    List<SeatReserved> getReservedSeatsByShowId(Long showId);

    SeatReserved getSeatReservedBySeatAndShow(Seat seat, Show show);

    @Query(value = "SELECT NEW com.codecool.moviereactorapplication.model.SeatReservedWithDetails(sr.id, s.id, s.startingDate, s.startingTime, m.movieDbId, st.rowNumber, st.seatNumber) " +
            "FROM SeatReserved AS sr JOIN Seat st ON sr.seat.id = st.id JOIN Show s ON sr.show.id = s.id JOIN Movie m on s.movie.id = m.id " +
            "ORDER BY s.startingDate"
    )
    List<SeatReservedWithDetails> getAllReservationsWithDetails();

    // TODO: Need to watch this query, can be a problem with it.
    void deleteById(Long Id);

    // TODO: Need to implement a query for: Get reserved seats by User, order by date, group by movie for easier display.
}
