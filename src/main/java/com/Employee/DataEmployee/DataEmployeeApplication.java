package com.Employee.DataEmployee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DataEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataEmployeeApplication.class, args);
	}

}
