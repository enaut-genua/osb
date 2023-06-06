package org.osb.web.domain.role.repository;

import org.osb.web.domain.role.model.Role;
import org.osb.web.domain.role.model.Role.RoleType;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
	Optional<Role> findByType(RoleType type);
}
