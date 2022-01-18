package getir.book.store.rest;

import getir.book.store.dto.Response;
import getir.book.store.entities.Book;
import getir.book.store.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books/")
public class BookResource {

    private BookService bookService;

    @PostMapping(value = "create",consumes = { MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public Response<Book> saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping(value = "update",consumes = { MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public Response<Book> update(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @GetMapping(value = "{bookId}")
    public Book findBookById(@PathVariable("bookId") Long id) {
        return bookService.findByBookId(id).orElse(Book.builder().build());
    }

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
}
