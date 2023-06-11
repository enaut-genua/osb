package org.osb.web.config;

import java.io.IOException;
import java.util.Set;

import org.osb.web.domain.role.model.Role;
import org.osb.web.domain.role.model.Role.RoleType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

	private String[] resources = {"/css/**", "/js/**", "/images/**"};
	private String[] authenticated = {"/menu", "/ikasgaiak/**", "/gaiak/**", "/apunteak/**", "/ourws/**", "/ws/**"}; 
	private String[] admin = {"/users", "/administration/**", "/register/**"}; 

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(
						authorize -> authorize
								.requestMatchers(resources).permitAll()
								.requestMatchers(authenticated).authenticated()
								.requestMatchers(admin).hasRole(RoleType.Administrator.name()))
				.formLogin(
						form -> form
								.loginPage("/login").permitAll()
								.loginProcessingUrl("/login")
								.successHandler(new AuthenticationSuccessHandler() {
									private SimpleUrlAuthenticationSuccessHandler adminSuccessHandler = new SimpleUrlAuthenticationSuccessHandler(
											"/administration");
									private SimpleUrlAuthenticationSuccessHandler elseSuccessHandler = new SimpleUrlAuthenticationSuccessHandler(
											"/ikasgaiak");

									@Override
									public void onAuthenticationSuccess(HttpServletRequest request,
											HttpServletResponse response, Authentication authentication)
											throws IOException, ServletException {
										Set<String> roles = AuthorityUtils
												.authorityListToSet(authentication.getAuthorities());
										if (roles.contains(Role.NAME_PREFIX + RoleType.Administrator.name())) {
											adminSuccessHandler.onAuthenticationSuccess(request, response,
													authentication);
										} else {
											elseSuccessHandler.onAuthenticationSuccess(request, response,
													authentication);
										}
									}
								}))
				.logout(
						logout -> logout
								.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
								.permitAll());
		return http.build();
	}

	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder());
	}
}
