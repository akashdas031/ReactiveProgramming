package org.springreactive.com.SpringReactiveCRUD.Entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="reactive_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReactiveUser implements Persistable<String>{

	@Id
	private String id;
	private String name;
	private String email;
	private LocalDateTime createdAt;
	@Transient
	private boolean isNew;
}
