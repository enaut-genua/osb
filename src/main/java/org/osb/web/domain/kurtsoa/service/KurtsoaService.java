package org.osb.web.domain.kurtsoa.service;

import java.util.List;

import org.osb.web.domain.kurtsoa.dto.KurtsoaDto;

public interface KurtsoaService {
    
    List<KurtsoaDto> findAllKurtsoas();

}