package org.osb.web.domain.ikasgaia.model;

import java.util.List;

import org.osb.web.domain.apuntea.model.Apuntea;
import org.osb.web.domain.azterketa.model.Azterketa;
import org.osb.web.domain.gaia.model.Gaia;
import org.osb.web.domain.irakaslea.model.Irakaslea;
import org.osb.web.domain.kurtsoa.model.Kurtsoa;

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
@Table(name = "Ikasgaia")
public class Ikasgaia {

    @SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ikasgaiID;

    @Column(nullable = false)
	private String izena;

    @OneToMany(mappedBy = "ikasgaia")
    private List<Gaia> gaiak;

    @OneToMany(mappedBy = "ikasgaia")
    private List<Azterketa> azterketak;

    @OneToMany(mappedBy = "ikasgaia")
    private List<Apuntea> apunteak;

    @ManyToOne
    private Kurtsoa kurtsoa;

    @ManyToOne
    private Irakaslea irakaslea;

}

/*
 * create table Ikasgaia (
	ikasgaiID		tinyint,
    izena 			varchar(50),
    kurtsoID		tinyint,
    irakasleNAN		int unsigned,
    constraint IKASGAI_PK primary key (ikasgaiID),
    constraint IKASGAI_KURTSO_FK foreign key (kurtsoID) references Kurtsoa (kurtsoID),
    constraint IKASGAI_IRAKASLE_FK foreign key (irakasleNAN) references Irakaslea (NAN));
 */