package com.sede.tutorial.customer;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class CustomerService {
    public List<Customer> getCustomers(){
            return List.of(
                    new Customer(
                        1L,
                                "Alexman",
                                "alexman@ale.com",
                        LocalDate.of(2000, Month.MARCH, 10),
                        20
                    )
            );
    }
}