package ru.isshepelev.mockmvc.service;

import ru.isshepelev.mockmvc.dto.BookDTO;
import ru.isshepelev.mockmvc.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    void addBook(BookDTO bookDTO);
    Book findByBookId(Long id);
    Book findByName(String name);
    Book findByAuthor(String name);
}
