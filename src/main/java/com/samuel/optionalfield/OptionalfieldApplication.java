package com.samuel.optionalfield;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;


//@Profile("h2")
@SpringBootApplication
public class OptionalfieldApplication {

	public static void main(String[] args) {
		SpringApplication.run(OptionalfieldApplication.class, args);
	}

}
