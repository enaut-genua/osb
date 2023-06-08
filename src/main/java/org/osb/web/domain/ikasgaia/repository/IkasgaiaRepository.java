package org.osb.web.domain.ikasgaia.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import org.osb.web.domain.ikasgaia.model.Ikasgaia;

public interface IkasgaiaRepository extends CrudRepository<Ikasgaia, Long> {
    
    Optional<Ikasgaia> findByIzena(String izena);

}