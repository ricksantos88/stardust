package com.consumer.swapi.stardust;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StardustApplication {

	public static void main(String[] args) {
		SpringApplication.run(StardustApplication.class, args);
	}

}
