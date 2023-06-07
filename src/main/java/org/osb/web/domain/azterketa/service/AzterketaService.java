package org.osb.web.domain.azterketa.service;

import java.util.List;

import org.osb.web.domain.azterketa.dto.AzterketaDto;

public interface AzterketaService {
    
    List<AzterketaDto> findAllAzterketas();

}