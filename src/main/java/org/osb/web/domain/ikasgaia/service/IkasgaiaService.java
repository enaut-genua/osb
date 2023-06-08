package org.osb.web.domain.ikasgaia.service;

import java.util.List;

import org.osb.web.domain.gaia.dto.GaiaDto;
import org.osb.web.domain.gaia.model.Gaia;
import org.osb.web.domain.ikasgaia.dto.IkasgaiaDto;

public interface IkasgaiaService {

    List<IkasgaiaDto> findAllIkasgaias();
    
    IkasgaiaDto findIkasgaiaDtoByID(Long id);

    List<GaiaDto> findGaiakDtoByIkasgaiaID(Long ikasgaiID);

    List<Gaia> findGaiakByIkasgaiaID(Long ikasgaiID);

}