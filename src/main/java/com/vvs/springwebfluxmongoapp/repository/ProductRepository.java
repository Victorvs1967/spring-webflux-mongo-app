package com.vvs.springwebfluxmongoapp.repository;

import com.vvs.springwebfluxmongoapp.model.Product;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
}
