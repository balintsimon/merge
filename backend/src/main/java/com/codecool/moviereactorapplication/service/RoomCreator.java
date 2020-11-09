package com.codecool.moviereactorapplication.service;

import com.codecool.moviereactorapplication.entity.Room;
import com.codecool.moviereactorapplication.repository.RoomRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class RoomCreator {

    private final RoomRepository roomRepository;

    private final List<String> roomNames = Arrays.asList("Patkós Irma", "Huszárik Zoltán", "Uránia");
    Random random = new Random();

    public RoomCreator(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void createNumberedRooms(int numberOfRooms) {
        List<Room> rooms = new ArrayList<>();
        for (int roomId = 1; roomId < numberOfRooms+1; roomId++) {
            String name = roomNames.get(random.nextInt(roomNames.size()));
            Room newRoom = Room.builder()
                    .name(name)
                    .numberOfRows(5)
                    .numberOfSeatsPerRow(9)
                    .build();
            newRoom.setCapacity();
            rooms.add(newRoom);
        }
        roomRepository.saveAll(rooms);
    }
}
