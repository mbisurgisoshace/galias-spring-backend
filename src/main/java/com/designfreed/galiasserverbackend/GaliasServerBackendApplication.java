package com.designfreed.galiasserverbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.designfreed")
public class GaliasServerBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(GaliasServerBackendApplication.class, args);
	}
}
