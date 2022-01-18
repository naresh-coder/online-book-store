package getir.book.store.repositories;

import getir.book.store.entities.Order;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order,Long> {

    List<Order> findByOrderDateBetween(Date startDate,Date endDate);

}

