package getir.book.store.service;

import getir.book.store.dto.Response;
import getir.book.store.entities.Book;
import getir.book.store.repositories.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Response<Book> saveBook(Book book){

        try {
            log.info(" storing book",book);
            bookRepository.save(book);
            return Response.<Book>builder().data(book).message("Successfully stored  ").statusCode("200").build();
        } catch (Exception e) {
            log.error("Exception while storing book  ",e);
            return Response.<Book>builder().message("Exception raised ").statusCode("500").build();
        }

    }
    public  Response<Book> updateBook(Book book){
        try{
            Book book1 = bookRepository.findById(book.getBookId()).get();
            book1.setAuthor(book.getAuthor());
            book1.setBookDescription(book.getBookDescription());
            book1.setBookName(book.getBookName());
            bookRepository.save(book1);
            return Response.<Book>builder().data(book1).message("Successfully updated ").statusCode("200").build();
        }
        catch (Exception e) {
            log.error("Exception while storing book  ",e);
            return Response.<Book>builder().message("Exception raised ").statusCode("500").build();
        }


    }

    public Optional<Book> findByBookId(Long id){
        return bookRepository.findById(id);
    }

}
