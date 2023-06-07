package org.osb.web.domain.gradua.service;

import java.util.List;

import org.osb.web.domain.gradua.dto.GraduaDto;

public interface GraduaService {

    List<GraduaDto> findAllGraduas();

}