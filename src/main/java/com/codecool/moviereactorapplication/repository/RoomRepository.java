package com.codecool.moviereactorapplication.repository;

import com.codecool.moviereactorapplication.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}
