package ru.isshepelev.mockmvc.service;

import org.springframework.http.ResponseEntity;
import ru.isshepelev.mockmvc.dto.BookDTO;
import ru.isshepelev.mockmvc.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    void addBook(Book book);
    Book findByBookId(Long id);
    Book findByName(String name);
    Book findByAuthor(String name);

    Book updateBook(Long id, Book book);

    Void deleteBook(Long id);

}
