package getir.book.store.rest;

import getir.book.store.dto.Response;
import getir.book.store.entities.Customer;
import getir.book.store.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("customer/")
public class CustomerResource {

    private CustomerService customerService;
     @PostMapping(value = "register",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
     public Response<Customer> registerCustomer(@RequestBody Customer customer){
         log.info(" Registering customer ....");
         return customerService.registerCustomer(customer);
     }

    @PutMapping(value = "unregister",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public Response<Customer> unRegisterCustomer(@RequestBody Customer customer){
        log.info(" un registering customer ....");
        return customerService.unregisterCustomer(customer);
    }

    @GetMapping(value = "{mobile}")
    public Response<Customer> getCustomerDetails(@PathVariable("mobile") String mobile){
        log.info(" get customer  by mobile....",mobile);
        return customerService.getCustomer(mobile);
    }

     @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
