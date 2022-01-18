package getir.book.store.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class Book {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Column(name="book_id")
 private Long bookId;
 private String bookName;
 private String Author;
 private String bookDescription;
 private Boolean isAvailable;

/*
 @ManyToOne
 @JoinColumn(name = "customer_id")
 private Customer customer;
*/


}
