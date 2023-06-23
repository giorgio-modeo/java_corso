package it.ictpiemonte.immobiliare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class ImmobiliareApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImmobiliareApplication.class, args);
	}

}
