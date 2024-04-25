package com.dhemaxTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.dhemaxTest"})
@SpringBootApplication
@EnableJpaRepositories("com.dhemaxTest.dao")
@EntityScan("com.DhemaxTest.model")
@Configuration
@EnableAutoConfiguration
public class DhemaxTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DhemaxTestApplication.class, args);
	}

}
