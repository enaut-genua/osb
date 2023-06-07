package org.osb.web.domain.user.model;

import java.util.Date;

import org.osb.web.domain.ikaslea.model.Ikaslea;
import org.osb.web.domain.irakaslea.model.Irakaslea;
import org.osb.web.domain.role.model.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "User")
@Table(name = "user")
public class User {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userID;
 
	@Column(nullable = false)
	private String izena;

	@Column(nullable = false)
	private String abizena;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;

	// @Column(nullable = false)
	// private Date jaiotzeData;	

	@OneToOne(mappedBy = "user")
	private Irakaslea irakaslea;

	@OneToOne(mappedBy = "user")
	private Ikaslea ikaslea;

	@ManyToOne
	private Role role;
}