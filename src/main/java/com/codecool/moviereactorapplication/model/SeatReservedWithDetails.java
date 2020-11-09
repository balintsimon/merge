package com.codecool.moviereactorapplication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class SeatReservedWithDetails {

    private Long id;
    private Long showId;
    private LocalDate startingDate;
    private LocalTime startingTime;
    private Integer movieDbId;
    private Integer rowNumber;
    private Integer seatNumber;

}
