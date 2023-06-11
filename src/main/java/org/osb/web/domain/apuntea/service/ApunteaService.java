package org.osb.web.domain.apuntea.service;

import java.util.List;
import java.util.Optional;

import org.osb.web.domain.apuntea.dto.ApunteaDto;
import org.osb.web.domain.apuntea.model.Apuntea;
import org.osb.web.domain.apuntea.projection.ApunteaProjection;

public interface ApunteaService {
	Optional<ApunteaDto> findApunteaDtoById(Long id);
	Optional<Apuntea> findApunteaById(Long id);
	Optional<Integer> findApunteaPuntuazioaById(Long id);
	void saveApuntea(ApunteaDto apunteaDto);
	List<ApunteaDto> findAllApunteaDto();
	List<ApunteaDto> findApunteakInfo();
}