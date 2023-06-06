package org.osb.web.security;

import org.osb.web.domain.role.model.Role;
import org.osb.web.domain.user.model.User;
import org.osb.web.domain.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Invalid username or password."));
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				Arrays.asList(new SimpleGrantedAuthority(Role.NAME_PREFIX + user.getRole().getType().name())));
	}
}
