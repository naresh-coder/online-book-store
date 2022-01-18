package getir.book.store.service;

import getir.book.store.dto.Response;
import getir.book.store.entities.Customer;
import getir.book.store.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({  MockitoExtension.class })
class CustomerServiceTest {

     @InjectMocks
     CustomerService customerService;

     @Mock
     CustomerRepository customerRepository;

    @Test
    void registerCustomer() {
        Customer customer = Customer.builder().emailId("test@mail.com").mobile("232323232").username("test1").build();
        Response<Customer> c  = customerService.registerCustomer(customer);
        assertNotNull(c);
    }

    @Test
    void unregisterCustomer() {
        Customer customer = Customer.builder().emailId("test@mail.com").mobile("232323232").username("test1").build();
        Response<Customer> c  = customerService.unregisterCustomer(customer);
        assertNotNull(c);
    }

    @Test
    void getCustomer() {
        Customer customer = Customer.builder().emailId("test@mail.com").mobile("232323232").username("test1").build();
        Mockito.when(customerRepository.findByMobile(Mockito.anyString())).thenReturn(customer);
        Response<Customer> c  = customerService.getCustomer("12122");
        assertNotNull(c);
    }

    @Test
    void setCustomerRepository() {
    }
}