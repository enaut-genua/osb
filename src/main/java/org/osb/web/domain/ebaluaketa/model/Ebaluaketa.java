package org.osb.web.domain.ebaluaketa.model;

import org.osb.web.domain.azterketa.model.Azterketa;
import org.osb.web.domain.ikaslea.model.Ikaslea;

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
@Table(name = "Ebaluaketa")
public class Ebaluaketa {
    
    @SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ebaluaketaID;

    @Column
    private double nota;

    @Column 
    private String komentarioa;

    @ManyToOne
    private Azterketa azterketa;

    @ManyToOne
    private Ikaslea ikaslea;

}