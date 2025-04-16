package org.springreactive.com.SpringReactiveCRUD.Services;

import org.springreactive.com.SpringReactiveCRUD.Entities.ReactiveUser;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReactiveService {

	Mono<ReactiveUser> createReactiveUser(ReactiveUser user);
	Flux<ReactiveUser> getAllUsers();
	Mono<ReactiveUser> getSingleUser(String userId);
	Mono<ReactiveUser> updateUser(ReactiveUser user,String userId);
	Mono<Void> deleteUser(String userId);
}
