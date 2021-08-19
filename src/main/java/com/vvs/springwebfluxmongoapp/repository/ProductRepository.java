package com.vvs.springwebfluxmongoapp.repository;

import com.vvs.springwebfluxmongoapp.model.Product;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveMongoRepository<Product, ObjectId> {
  Mono<Product> findById(String id);
}
