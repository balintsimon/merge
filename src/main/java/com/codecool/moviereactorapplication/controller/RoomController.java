package com.codecool.moviereactorapplication.controller;

import com.codecool.moviereactorapplication.entity.Room;
import com.codecool.moviereactorapplication.repository.RoomRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/room")
public class RoomController {
    private final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping("/{id}")
    public Optional<Room> getRoom(@PathVariable("id") Long id) {
        return roomRepository.findById(id);
    }
}
