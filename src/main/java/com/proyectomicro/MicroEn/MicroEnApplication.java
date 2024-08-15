package com.proyectomicro.MicroEn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroEnApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroEnApplication.class, args);
	}

}
