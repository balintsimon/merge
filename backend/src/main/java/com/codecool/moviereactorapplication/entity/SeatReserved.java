package com.codecool.moviereactorapplication.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
// TODO: check if possible to give unique constraint for the combination of seat+show
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"seat_id", "show_id"}) // Check if this actually works
})
public class SeatReserved {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JsonManagedReference
    private Seat seat;

    @ManyToOne
    @JsonBackReference
    private Show show;
}
