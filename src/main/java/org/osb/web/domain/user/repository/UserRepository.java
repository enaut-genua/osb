package org.osb.web.domain.user.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import org.osb.web.domain.user.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
    Optional<User> findByEmail(String email);

}