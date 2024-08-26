package com.unir.tienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication 
@EntityScan(basePackages = "com.unir.tienda.model.pojo")
@EnableJpaRepositories(basePackages = "com.unir.tienda.data")
@ComponentScan(basePackages = "com.unir.tienda")
public class TiendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaApplication.class, args);
	}

}
