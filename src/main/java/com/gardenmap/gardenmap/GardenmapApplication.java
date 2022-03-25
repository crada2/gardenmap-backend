package com.gardenmap.gardenmap;

import com.gardenmap.gardenmap.auth.configuration.WebSecurityConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class GardenmapApplication {
	public static void main(String[] args) {
		SpringApplication.run(GardenmapApplication.class, args);
	}

}
