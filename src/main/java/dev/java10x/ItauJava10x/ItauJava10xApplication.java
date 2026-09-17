package dev.java10x.ItauJava10x;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class ItauJava10xApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItauJava10xApplication.class, args);
	}

}
