package org.osb.web.domain.azterketa.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.osb.web.domain.azterketa.dto.AzterketaDto;
import org.osb.web.domain.azterketa.model.Azterketa;
import org.osb.web.domain.azterketa.repository.AzterketaRepository;
import org.osb.web.domain.azterketa.service.AzterketaService;

@Service
public class AzterketaServiceImpl implements AzterketaService {

    @Autowired
    private AzterketaRepository azterketaRepository;

    @Override
    public List<AzterketaDto> findAllAzterketas() {
        Iterable<Azterketa> azterketak = azterketaRepository.findAll();

        return StreamSupport.stream(azterketak.spliterator(), false).map(azterketa -> {
            AzterketaDto azterketaDto = new AzterketaDto();
            azterketaDto.setIzena(azterketa.getIzena());
            return azterketaDto;
            }).collect(Collectors.toList());
    }
    
}