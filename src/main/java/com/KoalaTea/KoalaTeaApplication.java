package com.KoalaTea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * This @SpringBootApplication annotation is a convenience. It is actually a combination
 * of several different annotations. These include:
 * 
 * @SpringBootConfiguration: This an alternative to the @Configuration tag. It allows
 * Spring to auto detect configuration.
 * @EnableAutoConfiguration: This enables the auto configuration of the Application
 * Context.
 * @ComponentScan: This indicates that Spring should scan this package for annotations.
 */

@SpringBootApplication
public class KoalaTeaApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(KoalaTeaApplication.class, args);
	}
}
