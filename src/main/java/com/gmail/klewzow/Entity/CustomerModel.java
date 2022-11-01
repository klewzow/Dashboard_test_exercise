package com.gmail.klewzow.Entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CustomerModel {

    private String name;
    private String company;
    private String phone;
    private String email;
    private String country;
    private Status status;
}
