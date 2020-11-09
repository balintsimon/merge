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
public class Room {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer numberOfRows;
    private Integer numberOfSeatsPerRow;
    private Integer capacity;

    public void setCapacity () {
        if (numberOfRows != null && numberOfSeatsPerRow != null) {
            this.capacity = numberOfRows * numberOfSeatsPerRow;
        }
    }

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    @OneToMany(mappedBy = "room", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Seat> seats;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    @OneToMany(mappedBy = "room", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Show> shows;
}
