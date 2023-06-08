package org.osb.web.domain.artxiboa.model;

import org.osb.web.domain.apuntea.model.Apuntea;
import org.osb.web.domain.gaia.model.Gaia;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Artxiboa")
public class Artxiboa {
    
    @SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long artxiboID;

    @Column
    private String izena;

    // aqui va el archivo (blob)
    //@Column
    @Lob
    @Column(length = 1000000)
    private byte[] dokumentua;

    @ManyToOne
    @JoinColumn(nullable = true)
    private Apuntea apuntea;

    @ManyToOne
    private Gaia gaia;

}

/*
 * create table Artxiboa (
	artxiboID		int,
	documento 		blob(4194304) not null, -- blob pilla 32Mb 
    gaiaID			int,
    apunteID		int,
    constraint ARTXIBO_PK primary key (artxiboID),
    constraint ARTXIBO_GAIA_FK foreign key (gaiaID) references Gaia (gaiaID),
    constraint ARTXIBO_APUNTE_FK foreign key (apunteID) references Apuntea (apunteID));
 */