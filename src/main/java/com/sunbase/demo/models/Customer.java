package com.sunbase.demo.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String phone;
}
