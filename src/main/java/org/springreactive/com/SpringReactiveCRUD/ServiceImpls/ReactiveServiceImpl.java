package org.springreactive.com.SpringReactiveCRUD.ServiceImpls;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springreactive.com.SpringReactiveCRUD.Entities.ReactiveUser;
import org.springreactive.com.SpringReactiveCRUD.Repositories.R2DBCRepository;
import org.springreactive.com.SpringReactiveCRUD.Services.ReactiveService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReactiveServiceImpl implements ReactiveService{

	private R2DBCRepository repo;
	public ReactiveServiceImpl(R2DBCRepository repo){
		this.repo=repo;
	}
	
	@Override
	public Mono<ReactiveUser> createReactiveUser(ReactiveUser user) {
		String userId=UUID.randomUUID().toString().substring(10).replaceAll("-", "").trim();
		user.setCreatedAt(LocalDateTime.now());
		user.setId(userId);
		user.markNew();
		Mono<ReactiveUser> createdUser = this.repo.save(user);
		return createdUser;
	}

	@Override
	public Flux<ReactiveUser> getAllUsers() {
		
		return this.repo.findAll();
	}

	@Override
	public Mono<ReactiveUser> getSingleUser(String userId) {
		Mono<ReactiveUser> user = this.repo.findById(userId).switchIfEmpty(Mono.error(new RuntimeException("User with given id not exist in the server")));
		return user;
	}
	@Override
	public Mono<ReactiveUser> updateUser(ReactiveUser updatedUserData, String userId) {
	    return repo.findById(userId)
	        .switchIfEmpty(Mono.error(new RuntimeException("Invalid Credentials...User you want to update does not exist in the Server")))
	        .flatMap(existingUser -> {
	            existingUser.setName(updatedUserData.getName());
	            existingUser.setEmail(updatedUserData.getEmail());
	            return repo.save(existingUser);
	        });
	}
	@Override
	public Mono<Void> deleteUser(String userId) {
		return this.repo.deleteById(userId);
		
	}

}
