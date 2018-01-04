package com.example.dto.stub;

import com.example.dto.Customer;

/**
 * @author Andrii Minchekov
 * @since 12/22/17.
 */
public class StubCustomer extends Customer {
    public StubCustomer() {
        this(1);
    }

    public StubCustomer(Integer id) {
        super(id, "anmi", 33);
    }
}
