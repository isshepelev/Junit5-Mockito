package ru.isshepelev.mockmvc.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.isshepelev.mockmvc.dto.BookDTO;
import ru.isshepelev.mockmvc.entity.Book;
import ru.isshepelev.mockmvc.repository.BookRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {
    @InjectMocks
    private BookServiceImpl bookService;
    @Mock
    private BookRepository bookRepository;

    @Test
    void testFindAll() {
        List<Book> books = Arrays.asList(
                new Book(1L, "Book1", "Author1"),
                new Book(2L, "Book2", "Author2"));

        when(bookRepository.findAll()).thenReturn(books);

        List<Book> result = bookService.findAll();

        assertEquals(2, result.size());
        assertEquals("Book1", result.get(0).getName());
        assertEquals("Book2", result.get(1).getName());
    }

    @Test
    void testAddBook() {
        Book book = new Book();

        bookService.addBook(book);

        verify(bookRepository, times(1)).save(any(Book.class));
    }

    @Test
    void testFindByBookId() {
        Long bookId = 1L;
        Book book = new Book(bookId, "Book1", "Author1");
        when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));

        Book result = bookService.findByBookId(bookId);

        assertNotNull(result);
        assertEquals(bookId, result.getId());
        assertEquals("Book1", result.getName());
    }

    @Test
    void testFindByName() {
        String bookName = "Book1";
        Book book = new Book(1L, bookName, "Author1");
        when(bookRepository.findBookByName(bookName)).thenReturn(book);

        Book result = bookService.findByName(bookName);

        assertNotNull(result);
        assertEquals(bookName, result.getName());
    }

    @Test
    void testFindByAuthor(){
        String author = "pushkin";
        Book book = Mockito.mock(Book.class);
        when(book.getAuthor()).thenReturn("pushkin");
        when(bookRepository.findBookByAuthor(author)).thenReturn(book);

        Book result = bookRepository.findBookByAuthor(author);

        assertNotNull(result);
        assertEquals(author, result.getAuthor());
    }

    @Test
    void findBookById(){
        Long id = 1L;
        Book book = new Book();
        book.setName("nameee");
        book.setAuthor("authorr");
        book.setId(id);

        when(bookRepository.findById(id)).thenReturn(Optional.of(book));

        Book result = bookService.findByBookId(id);

        assertEquals(book, result);
    }
}