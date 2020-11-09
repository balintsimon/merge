package com.codecool.moviereactorapplication.entity;

import com.codecool.moviereactorapplication.model.MovieType;
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
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    private Integer movieDbId;

    @Enumerated(EnumType.STRING)
    private MovieType movieType;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    @OneToMany(mappedBy = "movie", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Show> shows;
}
