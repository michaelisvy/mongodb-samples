package com.samples;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SupplierRepository extends MongoRepository<Supplier, String> {

    Supplier findByNumber(String number);

    void deleteByNumber(String number);
}
