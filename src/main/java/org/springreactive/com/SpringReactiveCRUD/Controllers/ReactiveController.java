package org.springreactive.com.SpringReactiveCRUD.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springreactive.com.SpringReactiveCRUD.Entities.ReactiveUser;
import org.springreactive.com.SpringReactiveCRUD.Services.ReactiveService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/ReactiveUser")
public class ReactiveController {

	private Logger logger=LoggerFactory.getLogger(ReactiveController.class);
	private ReactiveService service;
	public ReactiveController(ReactiveService service) {
		this.service=service;
	}
	//create user
	@PostMapping("/createUser")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<ReactiveUser> createUser(@RequestBody ReactiveUser user){
		return this.service.createReactiveUser(user);
	}
	//get All users
	@GetMapping("/getAllUsers")
	@ResponseStatus(HttpStatus.OK)
	public Flux<ReactiveUser> getAllUser(){
		return this.service.getAllUsers();
	}
	//get single user
	@GetMapping("/getSingleUser/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<ReactiveUser> getSingleUser(@PathVariable("id") String id){
		return this.service.getSingleUser(id);
	}
	
	//update user
	
	@PutMapping("/updateUser/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<ReactiveUser> updateUserDetails(@RequestBody ReactiveUser user,@PathVariable("id") String id){
		return this.service.updateUser(user, id);
	}
	@DeleteMapping("/deleteUser/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<Void> deleteUser(@PathVariable("id") String id){
		return this.service.deleteUser(id);
	}
	
}
