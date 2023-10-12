package ru.isshepelev.mockmvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc(printOnlyOnFailure = false)
@SpringBootTest
public class ControllerGetAndPostTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void getText() throws Exception {
        mockMvc.perform(get("/text"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string("это текствое сообщение"));
    }

    @Test
    void getOneBook() throws Exception {
        mockMvc.perform(get("/books/{id}", 2)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("litle baby"))
                .andExpect(jsonPath("$.author").value("dima"));

    }

    @Test
    void postOneBook() throws Exception {
        mockMvc.perform(post("/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"John\", \"author\": \"author\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("John"))
                .andExpect(jsonPath("$.author").value("author"));

    }
}
