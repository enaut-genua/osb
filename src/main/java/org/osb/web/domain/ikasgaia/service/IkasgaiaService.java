package org.osb.web.domain.ikasgaia.service;

import java.util.List;
import org.osb.web.domain.gaia.dto.GaiaDto;
import org.osb.web.domain.ikasgaia.dto.IkasgaiaDto;

public interface IkasgaiaService {
	List<IkasgaiaDto> findAllIkasgaias();
	List<GaiaDto> findByIkasgaia(String ikasgaiaIzena);
}