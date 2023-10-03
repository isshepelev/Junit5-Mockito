package ru.isshepelev.mockmvc.dto;

import lombok.Data;
import ru.isshepelev.mockmvc.entity.Book;

@Data
public class BookDTO {

    private String name;
    private String author;

    public static BookDTO toDto(Book book) {
        return new BookDTO() {
            {
                setName(book.getName());
                setAuthor(book.getAuthor());
            }
        };
    }
}
