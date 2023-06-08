package org.osb.web.domain.gaia.model;

import java.util.List;

import org.osb.web.domain.artxiboa.model.Artxiboa;
import org.osb.web.domain.ikasgaia.model.Ikasgaia;

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
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Gaia")
public class Gaia {
   
    @SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long gaiaID;

    @Column(nullable = false)
	private String izena;

    //@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@ManyToOne
	private Ikasgaia ikasgaia;

    @OneToMany(mappedBy = "gaia")
    private List<Artxiboa> artxiboak;

}

/*
 * create table Gaia (
	gaiaID			int,
    izena			varchar(15),
    ikasgaiID		tinyint,
    constraint GAIA_PK primary key (gaiaID),
    constraint GAIA_IKASGAI_FK foreign key (ikasgaiID) references Ikasgaia (ikasgaiID));
 */