package com.vvs.springwebfluxmongoapp.handler;

import com.vvs.springwebfluxmongoapp.dto.ProductDto;
import com.vvs.springwebfluxmongoapp.model.Product;
import com.vvs.springwebfluxmongoapp.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class ProductHandle {
  
  @Autowired
  private ProductRepository productRepository;

  public Mono<ServerResponse> getProducts(ServerRequest request) {
    Flux<Product> products = productRepository.findAll();
    return ServerResponse
            .ok()
            .contentType(APPLICATION_JSON)
            .body(products, Product.class);
  }

  public Mono<ServerResponse> getProduct(ServerRequest request) {
    Mono<Product> product = productRepository.findById(request.pathVariable("id"));
    return ServerResponse
            .ok()
            .contentType(APPLICATION_JSON)
            .body(product, Product.class);
  }

  public Mono<ServerResponse> newProduct(ServerRequest request) {
    Mono<Product> product = request.bodyToMono(Product.class);
    return ServerResponse
            .ok()
            .contentType(APPLICATION_JSON)
            .body(product.flatMap(this::save), Product.class);
  }

  public Mono<ServerResponse> deleteProduct(ServerRequest request) {
    Mono<Product> product = productRepository.findById(request.pathVariable("id"));
    return ServerResponse
            .ok()
            .contentType(APPLICATION_JSON)
            .body(product.flatMap(this::delete), Product.class);
  }

  public Mono<ServerResponse> updateProduct(ServerRequest request) {
    Mono<ProductDto> productDto = request.bodyToMono(ProductDto.class);
    return ServerResponse
            .ok()
            .contentType(APPLICATION_JSON)
            .body(productDto.flatMap(this::update), Product.class);
  }

  private Mono<Product> save(Product product) {
    return Mono.fromSupplier(() -> {
      productRepository.save(product).subscribe();
      return product;
    });
  }

  private Mono<Product> delete(Product product) {
    return Mono.fromSupplier(() -> {
      productRepository.delete(product).subscribe();
      return product;
    });
  }

  private Mono<Product> update(ProductDto productDto) {
    return Mono.fromSupplier(() -> {
      Product product = new Product();
      product.setId(productDto.getId());
      product.setName(productDto.getName());
      product.setPrice(productDto.getPrice());
      productRepository.save(product).subscribe();
      return product;
    });
  }

}
