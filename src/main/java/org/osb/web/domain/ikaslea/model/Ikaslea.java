package org.osb.web.domain.ikaslea.model;

import java.util.List;

import org.osb.web.domain.apuntea.model.Apuntea;
import org.osb.web.domain.azterketa.model.Azterketa;
import org.osb.web.domain.balorazioa.model.Balorazioa;
import org.osb.web.domain.gradua.model.Gradua;
import org.osb.web.domain.kurtsoa.model.Kurtsoa;
import org.osb.web.domain.user.model.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
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
@Entity(name = "Ikaslea")
@Table(name = "ikaslea")
public class Ikaslea {
    
    @SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ikasleID;

    @ManyToMany
    @JoinTable(
        name = "azterketa_ikaslea",
		joinColumns = {@JoinColumn(name = "ikaslea_ikasleid", referencedColumnName = "ikasleID")},
		inverseJoinColumns = {@JoinColumn(name = "azterketa_azterketaid", referencedColumnName = "azterketaID")}
	)
    private List<Azterketa> azterketak;

    // #############################################################
    @OneToMany(mappedBy = "ikaslea")
    private List<Balorazioa> balorazioak;
    // #############################################################

    @OneToMany(mappedBy = "ikaslea")
    private List<Apuntea> apunteak;

    @ManyToOne
    private Gradua gradua;

    @ManyToOne
    private Kurtsoa kurtsoa;

    @OneToOne
    //@JoinColumn(name = "user_userid")
    private User user;

}

/*
 * create table Ikaslea (
	NAN				int unsigned,
    izena			varchar(15) not null,
    abizenak		varchar(15) not null,
    email			varchar(50) not null,
    pasaihtza 		varchar(20) not null,
    jaiotzeData		date not null,
    graduID			tinyint,
    constraint IKASLE_PK primary key (NAN),
    constraint IKASLE_GRADU_FK foreign key (graduID) references Gradua (graduID));
 */