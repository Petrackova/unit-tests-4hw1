package dz;

import org.junit.jupiter.api.Test;
import seminars.fourth.book.Book;
import seminars.fourth.book.BookRepository;
import seminars.fourth.book.BookService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TestBook {
    @Test
    public void  findByIdBook() {
        BookRepository mockBook = mock(BookRepository.class);
        String nameId = "84";
        Book newBook = new Book(nameId, "1984","Джордж Оруэлл");
        when(mockBook.findById(nameId)).thenReturn(newBook);

        BookService bookService = new BookService(mockBook);
        Book result = bookService.findBookById(nameId);
        assertEquals(newBook,result);
    }

    @Test
    public void  findAllIdBook() {
        BookRepository mockBook = mock(BookRepository.class);
        List<Book> mockBook1 = new ArrayList<>();
        mockBook1.add(new Book("84", "1984","Джордж Оруэлл"));
        mockBook1.add(new Book("82", "Темная башня","Стивен Кинг"));
        mockBook1.add(new Book("03", "Код Да Винчи","Дэн Браун"));
        when(mockBook.findAll()).thenReturn(mockBook1);

        BookService bookService = new BookService(mockBook);
        List<Book> result = bookService.findAllBooks();
        assertEquals(mockBook1,result);
    }

}
