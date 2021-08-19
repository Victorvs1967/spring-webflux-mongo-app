package com.vvs.springwebfluxmongoapp.router;

import com.vvs.springwebfluxmongoapp.handler.ProductHandle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RouterFunctions.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class ProductRouter {
  
  @Bean
  public RouterFunction<ServerResponse> productsRouter(ProductHandle productHandle) {
    return route(GET("/product").and(accept(APPLICATION_JSON)), productHandle::getProducts)
            .andRoute(GET("/product/{id}").and(accept(APPLICATION_JSON)), productHandle::getProduct)
            .andRoute(POST("/product").and(accept(APPLICATION_JSON)), productHandle::newProduct)
            .andRoute(PUT("/product").and(accept(APPLICATION_JSON)), productHandle::updateProduct)
            .andRoute(DELETE("/product/{id}").and(accept(APPLICATION_JSON)), productHandle::deleteProduct);
  }
}
