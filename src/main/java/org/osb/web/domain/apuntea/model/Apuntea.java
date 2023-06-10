package org.osb.web.domain.apuntea.model;

import java.util.List;

import org.osb.web.domain.artxiboa.model.Artxiboa;
import org.osb.web.domain.balorazioa.model.Balorazioa;
import org.osb.web.domain.ikasgaia.model.Ikasgaia;
import org.osb.web.domain.ikaslea.model.Ikaslea;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Entity
@Table(name = "Apuntea")
public class Apuntea {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long apunteID;

	@Column(nullable = false)
	private String izena;

	@OneToMany(mappedBy = "apuntea")
	private List<Balorazioa> balorazioak;

	@ManyToOne
	private Ikasgaia ikasgaia;

	@ManyToOne
	private Ikaslea ikaslea;

	@OneToMany(mappedBy = "apuntea")
	private List<Artxiboa> artxiboak;
}