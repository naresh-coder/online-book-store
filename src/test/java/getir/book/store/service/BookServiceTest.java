package getir.book.store.service;


import getir.book.store.dto.Response;
import getir.book.store.entities.Book;
import getir.book.store.entities.Customer;
import getir.book.store.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
class BookServiceTest {
    @InjectMocks
    private BookService business;

    @Mock
    private BookRepository repository;

    @Test
    public void saveBookTest() {
        Book book = Book.builder().Author("test@mail.com").bookDescription("232323232").bookName("test1").build();
        Response<Book> c = business.saveBook(book);
        assertNotNull(c);
    }
    @Test
    public void updateBookTest() {
        Book book = Book.builder().Author("test@mail.com").bookId(101l).bookDescription("232323232").bookName("test1").build();
        Book customer1 = Book.builder().Author("test@mail.com_updated").bookDescription("232323232_updated").bookName("test1_)updated").build();
        Response<Book> c = business.updateBook(book);
        assertNotNull(c);
    }


}