package com.gmail.klewzow.Configurations.Services;

import com.gmail.klewzow.Entity.Customer;
import com.gmail.klewzow.Repositoties.CustomerRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class CustomerService  {


    private CustomerRepository customerRepository;

    public CustomerService() {
    }
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findByName(String customerName){
        return customerRepository.findByName(customerName);
    }
    public Customer findByName(Customer customer){
        return customerRepository.findByName(customer.getName());
    }

    public void saveCustomer(Customer customer){
        customerRepository.save(customer);
    }
    public void addAll(List<Customer> list) { customerRepository.saveAll(list); }


public String statistic(){
       return customerRepository.findStatistic();
}



}
