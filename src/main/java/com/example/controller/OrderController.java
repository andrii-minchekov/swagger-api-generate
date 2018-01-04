package com.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;
import static java.util.UUID.randomUUID;

@RestController
@Api(value = "Order API", description = "Order operations")
public class OrderController {

    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) {
        return new Order(now(), randomUUID().toString());
    }

    @ApiOperation(value = "get Order by Id", nickname = "getOrderUsingGet")
    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    public Order getOrder(@PathVariable("id") String id) {
        return new Order(now(), randomUUID().toString());
    }

    @Getter
    @Setter
    @AllArgsConstructor
    class Order {
        private LocalDateTime date;
        private String id;
    }

}
