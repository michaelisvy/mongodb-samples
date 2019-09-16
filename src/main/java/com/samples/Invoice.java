package com.samples;

import lombok.Data;
import org.springframework.data.annotation.TypeAlias;

@Data
@TypeAlias("Invoice")
public class Invoice {

    private String id;
    private String number;
    private float amount;

    public Invoice(String number, float amount) {
        this.number = number;
        this.amount = amount;
    }
}
