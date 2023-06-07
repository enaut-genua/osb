package org.osb.web.domain.gaia.service;

import java.util.List;
import org.osb.web.domain.artxiboa.dto.ArtxiboaDto;
import org.osb.web.domain.gaia.dto.GaiaDto;

public interface GaiaService {
    
    List<GaiaDto> findAllGaias();

	List<ArtxiboaDto> findArtxiboakByGaiaID(Long id);

}