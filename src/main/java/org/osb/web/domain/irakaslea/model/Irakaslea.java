package org.osb.web.domain.irakaslea.model;

import java.util.List;

import org.osb.web.domain.ikasgaia.model.Ikasgaia;
import org.osb.web.domain.user.model.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Entity(name = "Irakaslea")
@Table(name = "irakaslea")
public class Irakaslea {

    @SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long irakasleID;

    /* 
    @Column(nullable = false)
	private String izena;

    @Column(nullable = false)
	private String abizena;

    @Column(nullable = false, unique = true)
	private String email;

    @Column
	private String pasahitza;

    @Column(nullable = false)
	private Date jaiotzeData;
    */

    @OneToMany(mappedBy = "irakaslea")
    private List<Ikasgaia> ikasgaia;

    @OneToOne
    private User user;

}

/*
 * create table Irakaslea (
	NAN				int unsigned,
    izena			varchar(10),
    abizenak		varchar(15),
    email			varchar(50),
    pasaihtza 		varchar(20),
    jaiotzeData		date,
	constraint IRAKAS_PK primary key (NAN));
 */