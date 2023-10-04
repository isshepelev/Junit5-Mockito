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

    @Override
    public Book findByBookId(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()){
            Book book = bookOptional.get();
            return book;
        }
        return null;
    }

    @Override
    public Book findByName(String name) {
        Optional<Book> bookOptional = Optional.ofNullable(bookRepository.findBookByName(name));
        if (bookOptional.isPresent()){
            Book book = bookOptional.get();
            return book;
        }
        return null;
    }

    @Override
    public Book findByAuthor(String author) {
        Optional<Book> bookOptional = Optional.ofNullable(bookRepository.findBookByName(author));
        if (bookOptional.isPresent()){
            Book book = bookOptional.get();
            return book;
        }
        return null;
    }
}
