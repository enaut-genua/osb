package org.osb.web.domain.gaia.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import org.osb.web.domain.gaia.model.Gaia;

public interface GaiaRepository extends CrudRepository<Gaia, Long> {
    
    Optional<Gaia> findByGaiaID(Long id);

}