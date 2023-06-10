package org.osb.web.domain.kurtsoa.model;

import java.util.List;

import org.osb.web.domain.gradua.model.Gradua;
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
@Table(name = "Kurtsoa")
public class Kurtsoa { 
    
    @SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long kurtsoID;

    @Column(nullable = false)
	private String izena;

    @ManyToOne
    private Gradua gradua;

    @OneToMany(mappedBy = "kurtsoa")
    private List<Ikaslea> ikasleak;

    @OneToMany(mappedBy = "kurtsoa")
    private List<Ikasgaia> ikasgaiak;

}

/*
 * create table Kurtsoa (
	kurtsoID		tinyint,
    izena           varchar(20),
    graduID			tinyint,
    constraint KURTS_PK primary key (kurtsoID),
    constraint KURTS_GRADU_FK foreign key (graduID) references Gradua (graduID));
 */