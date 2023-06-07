package org.osb.web.domain.ikasgaia.repository;

import java.util.Optional;

import org.osb.web.domain.ikasgaia.model.Ikasgaia;
import org.springframework.data.repository.CrudRepository;

public interface IkasgaiaRepository extends CrudRepository<Ikasgaia, Integer> {
    
    Optional<Ikasgaia> findByIzena(String izena);

}