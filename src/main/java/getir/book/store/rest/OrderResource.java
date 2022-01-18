package getir.book.store.rest;

import getir.book.store.dto.OrderRequest;
import getir.book.store.dto.Response;
import getir.book.store.entities.Order;
import getir.book.store.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("orders/")
public class OrderResource {

    private OrderService orderService;

    @PostMapping(value = "create",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public Response<Order> createOrder(@RequestBody Order order){
        log.info(" creating  order ....");
        return orderService.placeOrder(order);
    }

    @PutMapping(value = "update",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public Response<Order> editOrder(@RequestBody Order order){
        log.info(" un registering customer ....");
        return orderService.findByOrderDate(order);
    }

    @PostMapping(value = "query",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public Response<List<Order>> getCustomerDetails(@RequestBody OrderRequest  orderRequest ){
        log.info(" getting report between two date {} {}....",orderRequest.getStartDate(),orderRequest.getEndDate());
        return orderService.findByOrderDate(orderRequest.getStartDate(),orderRequest.getEndDate());
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
