package com.sede.tutorial.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner  commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            Customer alexman =
                    new Customer(
                            "Alexman",
                            "alexman@ale.com",
                            LocalDate.of(2000, MARCH, 10)
                    );

            Customer jamile =
                    new Customer(
                            "Jamile",
                            "jamile@jam.com",
                            LocalDate.of(2003, FEBRUARY, 20)
                    );
            customerRepository.saveAll(
                    List.of(
                    alexman, jamile)
            );
        };
    }
}
