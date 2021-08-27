package com.vvs.springwebfluxmongoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class SpringWebfluxMongoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebfluxMongoAppApplication.class, args);
	}

}
