package com.codecool.moviereactorapplication.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Seat {
    @Id
    @GeneratedValue
    private Long id;

    private Integer rowNumber;
    private Integer seatNumber;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private Room room;

    @OneToMany(mappedBy = "seat", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<SeatReserved> seatReserved;
}
