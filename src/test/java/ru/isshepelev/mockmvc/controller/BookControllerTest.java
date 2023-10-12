package ru.isshepelev.mockmvc.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.isshepelev.mockmvc.entity.Book;
import ru.isshepelev.mockmvc.service.impl.BookServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
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
    void getFindBookById() throws Exception {
        mockMvc.perform(get("/books/2"))
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        content().json("""
                                {
                                    "id": 2,
                                    "name": "litle baby",
                                    "author": "dima"
                                }
                                """)
                );
    }

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
                                        "name": "name",
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