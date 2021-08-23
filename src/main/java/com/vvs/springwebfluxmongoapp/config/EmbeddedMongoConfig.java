package com.vvs.springwebfluxmongoapp.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.vvs.springwebfluxmongoapp.model.Product;
import com.vvs.springwebfluxmongoapp.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

// @Configuration
// @EnableReactiveMongoRepositories("com.vvs.springwebfluxmongoapp.repository")
// public class EmbeddedMongoConfig extends AbstractReactiveMongoConfiguration {
// public class EmbeddedMongoConfig {

  // @Autowired
  // private Environment environment;

  // @Override
  // @Bean
  // public MongoClient reactiveMongoClient() {
  //   int port = environment.getProperty("local.mongo.port", Integer.class);
  //   return MongoClients.create(String.format("mongodb://localhost:%d", port));
  // }

  // @Override
  // protected String getDatabaseName() {
  //   return "products_db";
  // }

  // @Bean
  // public CommandLineRunner insertAndView(ProductRepository repository, ApplicationContext context) {
  //   return args -> {
  //     repository.save(new Product("TV", 1000)).subscribe();
  //     repository.save(new Product("Phone", 500)).subscribe();
  //     repository.save(new Product("Table", 200)).subscribe();
  //     repository.save(new Product("Mirror", 20)).subscribe();
  //     repository.findAll().subscribe(System.out::println);
  //   };
  // }

// }