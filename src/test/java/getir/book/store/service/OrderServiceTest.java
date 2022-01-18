package getir.book.store.service;

import getir.book.store.dto.Response;
import getir.book.store.entities.Book;
import getir.book.store.entities.Customer;
import getir.book.store.entities.Order;
import getir.book.store.repositories.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({  MockitoExtension.class })
class OrderServiceTest {
    @InjectMocks
    OrderService orderService;
    @Mock
    OrderRepository orderRepository;
    @Test
    void placeOrder() {
        Book book = Book.builder().Author("test@mail.com").bookId(101l).bookDescription("232323232").bookName("test1").build();
        Book book1 = Book.builder().Author("test1@mail.com").bookId(1101l).bookDescription("2312323232").bookName("tes1t1").build();

        Customer customer = Customer.builder().emailId("test@mail.com").mobile("232323232").username("test1").build();

        HashSet<Book> books = new HashSet<>();
        books.add(book);
        books.add(book1);
        Order order =  Order.builder().orderDate(new Date(System.currentTimeMillis())).orderStatus("PLaced").books(books).customer(customer).build();
        Response<Order> c = orderService.placeOrder(order);
        assertNotNull(c);
    }

    @Test
    void updateOrder() {
        Book book = Book.builder().Author("test@mail.com").bookId(101l).bookDescription("232323232").bookName("test1").build();
        Book book1 = Book.builder().Author("test1@mail.com").bookId(1101l).bookDescription("2312323232").bookName("tes1t1").build();

        Customer customer = Customer.builder().emailId("test@mail.com").mobile("232323232").username("test1").build();

        HashSet<Book> books = new HashSet<>();
        books.add(book);
        books.add(book1);
        Order order =  Order.builder().orderDate(new Date(System.currentTimeMillis())).orderStatus("Deliveryed").books(books).customer(customer).build();
        Response<Order> c = orderService.findByOrderDate(order);
        assertNotNull(c);
    }

    @Test
    void testUpdateOrder() {
    }
}