package ru.isshepelev.mockmvc.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import ru.isshepelev.mockmvc.dto.BookDTO;
import ru.isshepelev.mockmvc.entity.Book;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class BookRepositoryTest {

    @Mock
    List<?> mockList;

    @Test
    public void whenMockAnnotation() {
        doReturn("Иван").when(mockList).get(10);
        doReturn("Марья").when(mockList).get(500);

        assertEquals("Иван", mockList.get(10));
        assertEquals("Марья", mockList.get(500));
    }

    @Test
    void MockAny() {
        doReturn("Иван").when(mockList).get(anyInt());

        assertEquals("Иван", mockList.get(3));
    }

    @Test
    void inOrderMock() {
        mockList.size();
        mockList.get(4);
        mockList.clear();

        InOrder inOrder = Mockito.inOrder(mockList);
        inOrder.verify(mockList).size();
        inOrder.verify(mockList).get(4);
        inOrder.verify(mockList).clear();
    }

    @Test
    void ThrowsMock() {
        when(mockList.size()).thenThrow(IllegalStateException.class);

        assertThrows(IllegalStateException.class, () -> mockList.size());
    }
}