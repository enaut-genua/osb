package org.osb.web.domain.ikaslea.service;

import java.util.List;

import org.osb.web.domain.ikasgaia.dto.IkasgaiaDto;
import org.osb.web.domain.ikaslea.dto.IkasleaDto;

public interface IkasleaService {
    
    List<IkasleaDto> findAllIkasleas(); 
    List<IkasgaiaDto> findIkasgaiakByUser(String username);
    
}