package ru.isshepelev.mockmvc.dto;

import lombok.Builder;
import lombok.Data;
import ru.isshepelev.mockmvc.entity.Book;

@Data
@Builder
public class BookDTO {

    private String name;
    private String author;
}
