package org.osb.web.domain.user.service;

import java.util.List;
import java.util.Optional;

import org.osb.web.domain.user.dto.UserDto;
import org.osb.web.domain.user.model.User;

public interface UserService {
	void saveUser(UserDto userDto);
	Optional<User> findByEmail(String email);
	List<UserDto> findAllUsers();
}