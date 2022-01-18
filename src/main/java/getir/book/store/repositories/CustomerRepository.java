package getir.book.store.repositories;

import getir.book.store.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository  extends CrudRepository<Customer,Long> {

    Customer findByMobile(String mobile);

    Optional<Customer> findByUsername(String username);
}
