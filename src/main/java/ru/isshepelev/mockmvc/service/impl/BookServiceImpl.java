package ru.isshepelev.mockmvc.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.isshepelev.mockmvc.dto.BookDTO;
import ru.isshepelev.mockmvc.entity.Book;
import ru.isshepelev.mockmvc.repository.BookRepository;
import ru.isshepelev.mockmvc.service.BookService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void addBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setName(bookDTO.getName());
        book.setAuthor(bookDTO.getAuthor());
        bookRepository.save(book);
    }
}
