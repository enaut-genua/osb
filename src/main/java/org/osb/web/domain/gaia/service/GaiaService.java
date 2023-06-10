package org.osb.web.domain.gaia.service;

import java.util.List;

import org.osb.web.domain.artxiboa.dto.ArtxiboaDto;
import org.osb.web.domain.artxiboa.projection.ArtxiboaProjection;
import org.osb.web.domain.gaia.dto.GaiaDto;
import org.osb.web.domain.gaia.model.Gaia;

public interface GaiaService {

	List<GaiaDto> findAllGaias();

	List<ArtxiboaDto> findArtxiboakByGaiaID(Long id);

	public void saveGaia(GaiaDto gaiaDto);

	List<ArtxiboaDto> findLehenengoGaiarenArtxiboak(List<Gaia> gaiak);

	List<ArtxiboaProjection> findData(Long id);

}