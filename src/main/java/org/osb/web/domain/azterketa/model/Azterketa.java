package org.osb.web.domain.azterketa.model;

import java.util.List;

import org.osb.web.domain.ebaluaketa.model.Ebaluaketa;
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


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Azterketa")
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

    @OneToMany(mappedBy = "azterketa")
    private List<Ebaluaketa> ebaluaketak;
    
}