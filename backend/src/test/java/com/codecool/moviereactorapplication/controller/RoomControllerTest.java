package com.codecool.moviereactorapplication.controller;

import com.codecool.moviereactorapplication.repository.RoomRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DataJpaTest
class RoomControllerTest {
    @Autowired
    RoomRepository roomRepository;

    @Test
    void testValidInputWithValidRoomIdThenReturns200StatusCode() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new RoomController(this.roomRepository)).build();
        mockMvc.perform(MockMvcRequestBuilders
                .get("/room/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testMissingIdThenReturns4xxStatusCode() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new RoomController(this.roomRepository)).build();
        mockMvc.perform(MockMvcRequestBuilders
                .get("/room")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void testForPostMethodThenReturns4xxStatusCode() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new RoomController(this.roomRepository)).build();
        mockMvc.perform(MockMvcRequestBuilders
                .post("/room/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void testForStringInsteadIntegerParameterThenReturns4xxStatusCode() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new RoomController(this.roomRepository)).build();
        mockMvc.perform(MockMvcRequestBuilders
                .get("/room/{id}", "Not Integer")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


}