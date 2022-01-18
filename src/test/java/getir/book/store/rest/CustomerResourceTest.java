package getir.book.store.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import getir.book.store.dto.Response;
import getir.book.store.entities.Customer;
import getir.book.store.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.ResultActions;


@WebMvcTest(CustomerResource.class)

class CustomerResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Test
    void registerCustomer() throws Exception {
        Customer customer = Customer.builder().emailId("test@mail.com").mobile("232323232").username("test1").build();
        Response<Customer> response = Response.<Customer>builder().data(customer).build();
        Mockito.when(customerService.registerCustomer(Mockito.any())).thenReturn(response);
        ResultActions resultActions = this.mockMvc.perform(post("/customer/register").content(toJson(customer)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(toJson(customer))).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("test1")));


    }

    private String toJson(final Object object) throws JsonProcessingException {

        return new ObjectMapper().writeValueAsString(object);

    }

    @Test
    void unRegisterCustomer() throws Exception {
        Customer customer = Customer.builder().emailId("test@mail.com").mobile("232323232").username("test1").build();
        Response<Customer> response = Response.<Customer>builder().data(customer).build();
        Mockito.when(customerService.unregisterCustomer(Mockito.any())).thenReturn(response);
        ResultActions resultActions = this.mockMvc.perform(put("/customer/unregister").content(toJson(customer)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(toJson(customer))).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("test1")));

    }

    @Test
    void getCustomerDetails() throws Exception {
        Customer customer = Customer.builder().emailId("test@mail.com").mobile("232323232").username("test1").build();
        Response<Customer> response = Response.<Customer>builder().data(customer).build();
        Mockito.when(customerService.getCustomer(Mockito.any())).thenReturn(response);
        ResultActions resultActions = this.mockMvc.perform(get("/customer/95555")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("test1")));

    }
}