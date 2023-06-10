package org.osb.web.domain.azterketa.repository;

import org.springframework.data.repository.CrudRepository;

import org.osb.web.domain.azterketa.model.Azterketa;
import org.osb.web.domain.ebaluaketa.model.Ebaluaketa;

public interface AzterketaRepository extends CrudRepository<Azterketa, Long> {

	Azterketa findByEbaluaketak(Ebaluaketa ebaluaketa);
    
}