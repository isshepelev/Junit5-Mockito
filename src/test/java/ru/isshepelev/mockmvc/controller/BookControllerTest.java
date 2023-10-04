package ru.isshepelev.mockmvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.isshepelev.mockmvc.service.impl.BookServiceImpl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(printOnlyOnFailure = false)
class BookControllerTest {

    @Autowired
    private  MockMvc mockMvc;
    @Autowired
    private  BookServiceImpl bookService;



    @Test
    void getAllBooks() throws Exception {
        var requestBuilder = get("/books");

        this.mockMvc.perform(requestBuilder)
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        content().json("""
                                [
                                    {
                                        "id": 1,
                                        "name": "mammy",
                                        "author": "Ilya"
                                    },
                                    {
                                        "id": 2,
                                        "name": "litle baby",
                                        "author": "dima"
                                    },
                                    {
                                        "id": 3,
                                        "name": "big boy",
                                        "author": "sahsa"
                                    }
                                ]
                                """)
                );
    }

}