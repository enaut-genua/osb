package org.osb.web.domain.apuntea.repository;


import java.util.List;

import org.osb.web.domain.apuntea.model.Apuntea;
import org.osb.web.domain.apuntea.projection.ApunteaProjection;
import org.springframework.data.repository.CrudRepository;

public interface ApunteaRepository extends CrudRepository<Apuntea, Long> {

	List<ApunteaProjection> findAllApunteaBy();
}