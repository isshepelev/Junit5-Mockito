package ru.isshepelev.mockmvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(printOnlyOnFailure = false)
@SpringBootTest
public class ControllerPutTest {
    @Autowired
    MockMvc mockMvc;

//    @Test
//    void putTest() throws Exception {
//        mockMvc.perform(put("/update/{id}", 52)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"name\": \"new name\", \"author\": \"new author\"}")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
////                .andExpect(jsonPath("$.id").value(52))
//                .andExpect(jsonPath("$.name").value("new name"))
//                .andExpect(jsonPath("$.author").value("new author"));
//    }

    @Test
    void testPut(){

    }
}
//"id": 52,