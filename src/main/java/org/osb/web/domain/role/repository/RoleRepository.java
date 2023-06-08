package org.osb.web.domain.role.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import org.osb.web.domain.role.model.Role;
import org.osb.web.domain.role.model.Role.RoleType;

public interface RoleRepository extends CrudRepository<Role, Long> {
	Optional<Role> findByType(RoleType type);
}