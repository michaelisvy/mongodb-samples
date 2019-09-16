package com.samples;

import lombok.Data;

@Data
public class Address {
    private String streetAddress;
    private String zipcode;
    private String city;

    public Address(String streetAddress, String zipcode, String city) {
        this.streetAddress = streetAddress;
        this.zipcode = zipcode;
        this.city = city;
    }
}
