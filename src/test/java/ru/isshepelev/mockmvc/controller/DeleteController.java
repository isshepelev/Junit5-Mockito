package ru.isshepelev.mockmvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(printOnlyOnFailure = false)
@SpringBootTest
public class DeleteController {
    @Autowired
    MockMvc mockMvc;

    @Test
    void deleteTest() throws Exception{
        mockMvc.perform(delete("/delete/{id}", 102))
                .andExpect(status().isOk());
    }
}
