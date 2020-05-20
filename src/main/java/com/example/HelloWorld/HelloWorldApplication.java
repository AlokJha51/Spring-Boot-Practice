package com.example.HelloWorld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Controller;

import java.util.logging.Logger;

@SpringBootApplication
@Controller("com.example.HelloWorld")
public class HelloWorldApplication {
	private static Logger logger = Logger.getLogger(HelloWorldApplication.class.getName());

	public static void main(String[] args) {
		logger.info("SPRING VERSION: " + SpringVersion.getVersion());
		SpringApplication.run(HelloWorldApplication.class, args);
	}

}
