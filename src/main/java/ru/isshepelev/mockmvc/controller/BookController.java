package ru.isshepelev.mockmvc.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.isshepelev.mockmvc.dto.BookDTO;
import ru.isshepelev.mockmvc.entity.Book;
import ru.isshepelev.mockmvc.repository.BookRepository;
import ru.isshepelev.mockmvc.service.BookService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class BookController {
    private final BookService bookService;
    private final BookRepository bookRepository;


    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBook(){
        List<Book> bookList = bookService.findAll();
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getOneBook(@PathVariable Long id){
        return ResponseEntity.ok(bookService.findByBookId(id));
    }

    @GetMapping("/text")
    public ResponseEntity<String> text(){
        return ResponseEntity.ok().body("это текствое сообщение");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Book> bookUpdate(@PathVariable Long id,
                                           @RequestBody Book book){
        return ResponseEntity.ok().body(bookService.updateBook(id,book));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        return ResponseEntity.ok(bookService.deleteBook(id));
    }
}
