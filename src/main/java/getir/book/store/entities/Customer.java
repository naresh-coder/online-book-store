package getir.book.store.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@Entity(name = "customers")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="customer_id")
    private Long id;
    private String username;
    private String emailId;
    private String mobile;
    private String password;
    private String isAction;

}
