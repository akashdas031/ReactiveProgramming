package org.springreactive.com.SpringReactiveCRUD.Repositories;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springreactive.com.SpringReactiveCRUD.Entities.ReactiveUser;

public interface R2DBCRepository extends R2dbcRepository<ReactiveUser, String>{

}
