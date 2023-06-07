package org.osb.web.domain.irakaslea.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.osb.web.domain.irakaslea.dto.IrakasleaDto;
import org.osb.web.domain.irakaslea.model.Irakaslea;
import org.osb.web.domain.irakaslea.repository.IrakasleaRepository;
import org.osb.web.domain.irakaslea.service.IrakasleaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IrakasleaServiceImpl implements IrakasleaService {
    
    @Autowired
    private IrakasleaRepository irakasleaRepository;

    @Override
    public List<IrakasleaDto> findAllIrakasleas() {
        Iterable<Irakaslea> irakasleak = irakasleaRepository.findAll();

        return StreamSupport.stream(irakasleak.spliterator(), false).map(irakaslea -> {
            IrakasleaDto irakasleaDto = new IrakasleaDto();
            //irakasleaDto.setIzena(irakaslea.getIzena());
            //irakasleaDto.setAbizena(irakaslea.getAbizena());
            //irakasleaDto.setEmail(irakaslea.getEmail());
            //irakasleaDto.setJaiotzeData(irakaslea.getJaiotzeData());
            return irakasleaDto;
            }).collect(Collectors.toList());
    }

}