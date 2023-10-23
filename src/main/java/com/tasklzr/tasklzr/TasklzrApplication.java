package com.tasklzr.tasklzr;

import com.tasklzr.tasklzr.adapters.CheckOrUncheckTaskGateway;
import com.tasklzr.tasklzr.security.infra.SecurityConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan("com")
@Component
public class TasklzrApplication extends SpringBootServletInitializer {

	@Override protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(TasklzrApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(TasklzrApplication.class, args);
	}

}
