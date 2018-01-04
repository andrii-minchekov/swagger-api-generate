package com.example.controller;

import com.example.dto.CreateCustomerResp;
import com.example.dto.Customer;
import com.example.dto.stub.StubCustomer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author Andrii Minchekov
 * @since 12/21/17.
 */

@RestController
@Api(value = "Customer API", description = "Customer operations")
public class CustomerController {

    @ApiOperation(value = "Get collection of all customers", response = Iterable.class)
    @RequestMapping(value = "/customers", method = RequestMethod.GET, produces = APPLICATION_JSON_UTF8_VALUE)
    public Collection<Customer> getAllCustomers() {
        return Arrays.asList(new StubCustomer(1), new StubCustomer(2));
    }

    @ApiOperation(value = "Get customer by ID", response = Customer.class)
    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_UTF8_VALUE)
    public Customer getCustomer(@PathVariable("id") Integer id) {
        return new StubCustomer();
    }

    @ApiOperation(value = "Create new customer", nickname = "addCustomerUsingPOST", response = CreateCustomerResp.class)
    @RequestMapping(value = "/customers", method = RequestMethod.POST,
            produces = APPLICATION_JSON_UTF8_VALUE, consumes = APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public CreateCustomerResp createCustomer(@RequestBody Customer customer) {
        return new CreateCustomerResp(1);
    }
}