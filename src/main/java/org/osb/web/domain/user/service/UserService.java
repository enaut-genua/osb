package org.osb.web.domain.user.service;

import java.util.List;
import java.util.Optional;

import org.osb.web.domain.ikasgaia.dto.IkasgaiaDto;
import org.osb.web.domain.user.dto.UserDto;
import org.osb.web.domain.user.model.User;

public interface UserService {
	void saveUser(UserDto userDto);

	Optional<UserDto> findUserDtoByEmail(String email);

	Optional<User> findUserByEmail(String email);

	List<UserDto> findAllUsers();

	List<IkasgaiaDto> findIkasgaiakDtoByUser(String username);

}