package com.vvs.springwebfluxmongoapp.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document("products")
public class Product {
  
  @Id
  private ObjectId id;
  private String name;
  private long price;

  public Product(String name, long price) {
    this.name = name;
    this.price = price;
  }

  public void setId(String id) {
    this.id = new ObjectId(id);
  }

  public String getId() {
    return this.id.toHexString();
  }
}
