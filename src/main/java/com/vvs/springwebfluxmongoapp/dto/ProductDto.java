package com.vvs.springwebfluxmongoapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
  
  private String id;
  private String name;
  private long price;
  
}
