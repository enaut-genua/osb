package org.osb.web.domain.user.repository;

import java.util.Optional;

import org.osb.web.domain.user.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	
    Optional<User> findByEmail(String email);

}