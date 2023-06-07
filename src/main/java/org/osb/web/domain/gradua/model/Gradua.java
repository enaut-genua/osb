package org.osb.web.domain.gradua.model;

import java.util.List;

import org.osb.web.domain.ikaslea.model.Ikaslea;
import org.osb.web.domain.kurtsoa.model.Kurtsoa;

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
@Entity(name = "Gradua")
@Table(name = "gradua")
public class Gradua {

    @SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long graduID;

    @Column(nullable = false)
	private String izena;

    @OneToMany(mappedBy = "gradua")
    private List<Ikaslea> ikasleak;

    @OneToMany(mappedBy = "gradua")
    private List<Kurtsoa> kurtsoak;

}

/*
 * create table Gradua (
    graduID 		tinyint,
    izena			varchar (50),
    constraint GRAD_PK primary key (graduID));
 */