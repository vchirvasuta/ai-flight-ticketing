package com.badboys.ai.flying;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class FlyingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlyingApplication.class, args);
	}

}
