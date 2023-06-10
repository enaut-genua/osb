package org.osb.web.domain.ikasgaia.service;

import java.util.List;
import java.util.Optional;

import org.osb.web.domain.gaia.dto.GaiaDto;
import org.osb.web.domain.gaia.model.Gaia;
import org.osb.web.domain.ikasgaia.dto.IkasgaiaDto;
import org.osb.web.domain.ikasgaia.model.Ikasgaia;

public interface IkasgaiaService {

	List<IkasgaiaDto> findAllIkasgaias();

	Optional<IkasgaiaDto> findIkasgaiaDtoByID(Long id);

	Optional<Ikasgaia> findIkasgaiaByIzena(String izena);

	List<GaiaDto> findGaiakDtoByIkasgaiaID(Long ikasgaiID);

	List<Gaia> findGaiakByIkasgaiaID(Long ikasgaiID);

}