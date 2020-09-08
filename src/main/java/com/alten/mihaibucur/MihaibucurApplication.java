package com.alten.mihaibucur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MihaibucurApplication {

	public static void main(String[] args) {
		SpringApplication.run(MihaibucurApplication.class, args);
	}

}
