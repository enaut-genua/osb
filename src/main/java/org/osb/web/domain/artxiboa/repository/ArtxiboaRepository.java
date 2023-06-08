package org.osb.web.domain.artxiboa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import org.osb.web.domain.artxiboa.model.Artxiboa;
import org.osb.web.domain.gaia.model.Gaia;

public interface ArtxiboaRepository extends CrudRepository<Artxiboa, Long>{
    List<Artxiboa> findAllByGaia(Gaia gaia);
}