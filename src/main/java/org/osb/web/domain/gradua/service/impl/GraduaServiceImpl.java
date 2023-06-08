package org.osb.web.domain.gradua.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.osb.web.domain.gradua.dto.GraduaDto;
import org.osb.web.domain.gradua.model.Gradua;
import org.osb.web.domain.gradua.repository.GraduaRepository;
import org.osb.web.domain.gradua.service.GraduaService;

@Service
public class GraduaServiceImpl implements GraduaService {
   
    @Autowired
    private GraduaRepository graduaRepository;

    @Override
    public List<GraduaDto> findAllGraduas() {
        Iterable<Gradua> graduak = graduaRepository.findAll();

        return StreamSupport.stream(graduak.spliterator(), false).map(gradua -> {
            GraduaDto graduaDto = new GraduaDto();
            graduaDto.setIzena(gradua.getIzena());
            return graduaDto;
            }).collect(Collectors.toList());
    }
    
}