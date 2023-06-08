package org.osb.web.domain.role.model;

import java.util.List;

import org.osb.web.domain.user.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Role")
@Table(name = "role")
public class Role {

    public static final String NAME_PREFIX = "ROLE_";

	public enum RoleType {
		Administrator,
		Student,
		Teacher,
	}

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleID;

	@Column(nullable = false)
	private RoleType type;

	@OneToMany(mappedBy = "role")
	private List<User> users;

}