package com.samples;

import lombok.Data;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
// @Document is not specified. So Spring Data assumes that Collection name == class name == Supplier
@TypeAlias("Supplier")
public class Supplier {

    private String id; // convention: this field maps '_id_ in database
    private String number; // used as an identification number
    private String name;
    private Address address;

    @DBRef(lazy = true)
    private Invoice invoice;


    public Supplier(String number, String name) {
        this.number = number;
        this.name = name;
    }
}
