package org.osb.web.domain.gaia.repository;

import java.util.Optional;

import org.osb.web.domain.gaia.model.Gaia;
import org.springframework.data.repository.CrudRepository;

public interface GaiaRepository extends CrudRepository<Gaia, Long> {
    
    Optional<Gaia> findByGaiaID(Long id);

}