package org.osb.web.domain.user.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.osb.web.domain.role.model.Role;
import org.osb.web.domain.role.repository.RoleRepository;
import org.osb.web.domain.user.dto.UserDto;
import org.osb.web.domain.user.model.User;
import org.osb.web.domain.user.repository.UserRepository;
import org.osb.web.domain.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void saveUser(UserDto userDto) {
		User user = new User();
		user.setName(userDto.getName());
		user.setSurname(userDto.getSurname());
		user.setEmail(userDto.getEmail());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setRole(roleRepository.findByType(userDto.getRoleType()).orElseGet(() -> {
			Role newRole = new Role();
			newRole.setType(userDto.getRoleType());
			return roleRepository.save(newRole);
		}));
		userRepository.save(user);
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<UserDto> findAllUsers() {
		Iterable<User> users = userRepository.findAll();
		return StreamSupport
				.stream(users.spliterator(), false)
				.map(user -> {
					UserDto userDto = new UserDto();
					userDto.setName(user.getName());
					userDto.setSurname(user.getSurname());
					userDto.setEmail(user.getEmail());
					userDto.setRoleType(user.getRole().getType());
					return userDto;
				})
				.collect(Collectors.toList());
	}
}
