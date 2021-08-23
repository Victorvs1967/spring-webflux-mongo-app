package com.vvs.springwebfluxmongoapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document("products")
public class Product {
  
  @Id
  private String id;
  private String name;
  private long price;

  public Product(String name, long price) {
    this.name = name;
    this.price = price;
  }

}
