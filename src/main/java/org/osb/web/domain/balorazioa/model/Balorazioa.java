package org.osb.web.domain.balorazioa.model;

import org.osb.web.domain.apuntea.model.Apuntea;
import org.osb.web.domain.user.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Balorazioa")
public class Balorazioa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long balorazioID;
    
    @Column
    private int balorazioa;

    @ManyToOne
	private User user;

    @ManyToOne
	private Apuntea apuntea;

}