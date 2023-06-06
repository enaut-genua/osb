package org.osb.web.domain.user.dto;

import org.osb.web.domain.role.model.Role.RoleType;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private Long id;

	@NotEmpty
	private String name;

	@NotEmpty
	private String surname;

	@NotEmpty
	@Email
	private String email;

	@NotEmpty
	private String password;

	//@NotEmpty
	private RoleType roleType;
}
