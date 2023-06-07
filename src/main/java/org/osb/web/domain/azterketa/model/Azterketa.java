package org.osb.web.domain.azterketa.model;

import java.util.List;

import org.osb.web.domain.ebaluaketa.model.Ebaluaketa;
import org.osb.web.domain.ikasgaia.model.Ikasgaia;
import org.osb.web.domain.ikaslea.model.Ikaslea;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@Entity(name = "Azterketa")
@Table(name = "azterketa")
public class Azterketa {
    
    @SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long azterketaID;

    @Column(nullable = false)
	private String izena;

    @ManyToOne
    private Ikasgaia ikasgaia;

    @ManyToMany
    private List<Ikaslea> ikaslea;

    @OneToMany(mappedBy = "azterketa")
    private List<Ebaluaketa> ebaluaketak;
    
}

/*
 * create table Azterketa (
	azterketaID		tinyint unsigned,
    izena			varchar(20) not null,
    komentarioa		varchar(60),
    ikasgaiID		tinyint,
    constraint AZTERK_PK primary key (azterketaID),
    constraint AZTERK_IKASGAI_FK foreign key (ikasgaiID) references Ikasgaia (ikasgaiID));
 */