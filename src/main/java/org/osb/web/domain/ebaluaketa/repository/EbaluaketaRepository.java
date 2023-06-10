package org.osb.web.domain.ebaluaketa.repository;

import java.util.List;

import org.osb.web.domain.azterketa.model.Azterketa;
import org.osb.web.domain.ebaluaketa.model.Ebaluaketa;
import org.osb.web.domain.ikaslea.model.Ikaslea;
import org.springframework.data.repository.CrudRepository;

public interface EbaluaketaRepository extends CrudRepository<Ebaluaketa, Long> {
    Ebaluaketa findByAzterketa(Azterketa azterketa);
    List<Ebaluaketa> findByIkaslea(Ikaslea ikaslea);
}