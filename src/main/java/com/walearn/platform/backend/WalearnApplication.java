package com.walearn.platform.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EntityScan(basePackages = "com.walearn.platform.backend")
@EnableAsync
public class WalearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalearnApplication.class, args);
	}

}
