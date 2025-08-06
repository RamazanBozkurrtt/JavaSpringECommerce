package com.Ecommerce.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.Ecommerce"})
@ComponentScan(basePackages = {"com.Ecommerce"})
@EnableJpaRepositories(basePackages = {"com.Ecommerce.repository"})
@SpringBootApplication
public class TestBuildForECommerseApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestBuildForECommerseApplication.class, args);
	}

}
