package org.osb.web.domain.apuntea.repository;


import java.util.List;

import org.osb.web.domain.apuntea.model.Apuntea;
import org.osb.web.domain.apuntea.projection.ApunteaProjection;
import org.osb.web.domain.ikasgaia.model.Ikasgaia;
import org.springframework.data.repository.CrudRepository;

public interface ApunteaRepository extends CrudRepository<Apuntea, Long> {

	List<ApunteaProjection> findAllApunteaBy();
	List<ApunteaProjection> findAllApunteaByIkasgaia(Ikasgaia ikasgaia);
}