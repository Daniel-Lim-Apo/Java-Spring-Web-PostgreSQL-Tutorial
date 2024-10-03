package com.sede.tutorial.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public void addNewCustomer(Customer customer) {

        Optional<Customer> customerByEmail = customerRepository
                        .findCustomerByEmail(customer.getEmail());

        if (customerByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }

        customerRepository.save(customer);

    }

    public void deleteCustomer(Long customerId) {
        boolean customerExists = customerRepository.existsById(customerId);
        if (!customerExists){
            throw new IllegalStateException(
                    "Customer with id " + customerId + " does not exist."
            );
        }
        customerRepository.deleteById(customerId);

    }

    public void updateCustomer(Customer customer) {
        boolean customerExists = customerRepository.existsById(customer.getId());
        if (!customerExists){
            throw new IllegalStateException(
                    "Customer with id " + customer.getId() + " does not exist."
            );
        }
        customerRepository.save(customer);

    }
}