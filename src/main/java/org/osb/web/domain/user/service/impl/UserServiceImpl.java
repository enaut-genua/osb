package org.osb.web.domain.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.osb.web.domain.ikasgaia.dto.IkasgaiaDto;
import org.osb.web.domain.role.model.Role;
import org.osb.web.domain.role.model.Role.RoleType;
import org.osb.web.domain.role.repository.RoleRepository;
import org.osb.web.domain.user.dto.UserDto;
import org.osb.web.domain.user.model.User;
import org.osb.web.domain.user.repository.UserRepository;
import org.osb.web.domain.user.service.UserService;

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
		user.setIzena(userDto.getName());
		user.setAbizena(userDto.getSurname());
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
	public Optional<UserDto> findUserDtoByEmail(String email) {
		return userRepository
				.findByEmail(email)
				.map(user -> {
					UserDto userDto = new UserDto();
					userDto.setName(user.getIzena());
					userDto.setSurname(user.getAbizena());
					userDto.setEmail(user.getEmail());
					userDto.setPassword(user.getPassword());
					userDto.setRoleType(user.getRole().getType());
					userDto.setId(user.getUserID());
					return userDto;
				});
	}

	@Override
	public List<UserDto> findAllUsers() {
		Iterable<User> users = userRepository.findAll();
		return StreamSupport
				.stream(users.spliterator(), false)
				.map(user -> {
					UserDto userDto = new UserDto();
					userDto.setName(user.getIzena());
					userDto.setSurname(user.getAbizena());
					userDto.setEmail(user.getEmail());
					userDto.setRoleType(user.getRole().getType());
					return userDto;
				})
				.collect(Collectors.toList());
	}

	@Override
	public Optional<User> findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<IkasgaiaDto> findIkasgaiakDtoByUser(String username) {
		RoleType userRole = userRepository.findByEmail(username).get().getRole().getType();
		

		if (userRole == RoleType.Teacher) {
			return userRepository
				.findByEmail(username)
				.map(user -> user.getIrakaslea())
				.map(irakaslea -> irakaslea.getIkasgaia()
					.stream()
					.map(ikasgaia -> {
						IkasgaiaDto ikasgaiaDto = new IkasgaiaDto();
                        ikasgaiaDto.setIkasgaiID(ikasgaia.getIkasgaiID());
						ikasgaiaDto.setIzena(ikasgaia.getIzena());
						return ikasgaiaDto;	
					}).toList()).orElse(new ArrayList<>());
		} else {
			return userRepository
				.findByEmail(username)
				.map(user -> user.getIkaslea())
				.map(ikaslea -> ikaslea.getKurtsoa().getIkasgaiak()
					.stream()
					.map(ikasgaia -> {
						IkasgaiaDto ikasgaiaDto = new IkasgaiaDto();
                        ikasgaiaDto.setIkasgaiID(ikasgaia.getIkasgaiID());
						ikasgaiaDto.setIzena(ikasgaia.getIzena());
						return ikasgaiaDto;	
					}).toList()).orElse(new ArrayList<>());
		}
	}

}