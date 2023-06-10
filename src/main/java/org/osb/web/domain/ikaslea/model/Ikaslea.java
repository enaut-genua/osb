package org.osb.web.domain.ikaslea.model;

import java.util.List;

import org.osb.web.domain.apuntea.model.Apuntea;
import org.osb.web.domain.ebaluaketa.model.Ebaluaketa;
import org.osb.web.domain.gradua.model.Gradua;
import org.osb.web.domain.kurtsoa.model.Kurtsoa;
import org.osb.web.domain.user.model.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

@Entity
@Table(name = "Ikaslea")
public class Ikaslea {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ikasleID;

	@OneToMany(mappedBy = "ikaslea")
	private List<Apuntea> apunteak;

	@OneToMany(mappedBy = "ikaslea")
	private List<Ebaluaketa> ebaluaketak;

	@ManyToOne
	private Gradua gradua;

	@ManyToOne
	private Kurtsoa kurtsoa;

	@OneToOne
	private User user;

}