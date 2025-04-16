package org.springreactive.com.SpringReactiveCRUD;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springreactive.com.SpringReactiveCRUD.Entities.ReactiveUser;
import org.springreactive.com.SpringReactiveCRUD.Services.ReactiveService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class SpringReactiveCrudApplication implements CommandLineRunner{

private Logger logger=LoggerFactory.getLogger(SpringReactiveCrudApplication.class);
	
	private ReactiveService service;
	
	public SpringReactiveCrudApplication(ReactiveService service) {
		this.service=service;		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
