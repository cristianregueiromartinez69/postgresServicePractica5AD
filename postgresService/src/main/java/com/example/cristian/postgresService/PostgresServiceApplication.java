package com.example.cristian.postgresService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PostgresServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgresServiceApplication.class, args);
	}

}

//TODO: todos los endpoints funcionan, pasamos a llamada