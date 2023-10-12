package ru.isshepelev.mockmvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import ru.isshepelev.mockmvc.dto.BookDTO;
import ru.isshepelev.mockmvc.entity.Book;
import ru.isshepelev.mockmvc.repository.BookRepository;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import ru.isshepelev.mockmvc.service.impl.BookServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc(printOnlyOnFailure = false)
public class CRUDTest {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private BookServiceImpl service;
    @Autowired
    private BookRepository repository;
    @Autowired
    private MockMvc mockMvc;


//    @AfterEach
//    public void resetDb() {
//        repository.deleteAll();
//    }

    private Book createBook(String name, String author){
        Book book = new Book();
        book.setAuthor(author);
        book.setName(name);
        return repository.save(book);
    }

    @Test
    void getFindBookById() throws Exception {
        long id = createBook("имя книги", "автор книги").getId();

        mockMvc.perform(get("/books/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value("имя книги"))
                .andExpect(jsonPath("$.author").value("автор книги"));
    }

    @Test
    void putUpdateBookById()throws Exception{
        long id = createBook("имя книги", "автор книги").getId();

        mockMvc.perform(put("/update/{id}", id)
                        .content(objectMapper.writeValueAsString(new Book(312412L,"new book", "new author")))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(11617586))
                .andExpect(jsonPath("$.name").value("new book"))
                .andExpect(jsonPath("$.author").value("new author"));

    }
}
