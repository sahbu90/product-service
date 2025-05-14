package com.sahbu.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sahbu.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
