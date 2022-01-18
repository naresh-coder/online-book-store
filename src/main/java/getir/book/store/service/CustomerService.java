package getir.book.store.service;

import getir.book.store.dto.Response;
import getir.book.store.dto.UserPrincipal;
import getir.book.store.entities.Customer;
import getir.book.store.mapper.UserMapper;
import getir.book.store.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CustomerService   {
    protected  CustomerRepository customerRepository;

    @Autowired
    private UserMapper userMapper;

    public Response<Customer> registerCustomer(Customer customer){
        try {
            log.info(" registering customer",customer);
            customerRepository.save(customer);
            return Response.<Customer>builder().data(customer).message("Sucessfully Registeted ").statusCode("200").build();
        } catch (Exception e) {
            log.error("Exception while registering customer ",e);
            // need to use status code
            return Response.<Customer>builder().message("Registration failed ").statusCode("500").build();
        }
    }
    public Response<Customer> unregisterCustomer(Customer customer){

        try {
            Optional<Customer> customer1 = customerRepository.findById(customer.getId());
            log.info(" un registering customer",customer);
            if(customer1.isEmpty()){
                return Response.<Customer>builder().statusCode("200").message("customer is not exist").build();
            }
            customer1.get().setIsAction("InActive");
            customerRepository.save(customer);
           return Response.<Customer>builder().data(customer).message("Sucessfully Registeted ").statusCode("200").build();
        } catch (Exception e) {
            log.error("Exception while un registering customer ",e);
            // need to use status code
            return Response.<Customer>builder().message("Registration failed ").statusCode("500").build();
        }
    }

    public Response<Customer> getCustomer(String mobile){

        try {
            Customer customer1 = customerRepository.findByMobile(mobile);
            log.info(" getting customer details",customer1);
            if(customer1== null){
                return Response.<Customer>builder().statusCode("200").message("customer is not exist").build();
            }

            return Response.<Customer>builder().data(customer1).message("Sucessfully got customer details ").statusCode("200").build();
        } catch (Exception e) {
            log.error("Exception while getting customer details by ",e);
            // need to use status code
            return Response.<Customer>builder().message("Registration failed ").statusCode("500").build();
        }
    }


    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}
