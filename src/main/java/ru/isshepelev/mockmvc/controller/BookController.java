package ru.isshepelev.mockmvc.controller;

import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.isshepelev.mockmvc.dto.BookDTO;
import ru.isshepelev.mockmvc.entity.Book;
import ru.isshepelev.mockmvc.service.BookService;

import java.util.List;

@RestController
@AllArgsConstructor
public class BookController {
    private final BookService bookService;


    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBook(){
        List<Book> bookList = bookService.findAll();
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addBook(@RequestBody BookDTO bookDTO){
        bookService.addBook(bookDTO);
        return ResponseEntity.ok().build();
    }
}
