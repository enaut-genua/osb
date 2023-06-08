package org.osb.web.domain.ikaslea.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.osb.web.domain.ikasgaia.dto.IkasgaiaDto;
import org.osb.web.domain.ikaslea.dto.IkasleaDto;
import org.osb.web.domain.ikaslea.model.Ikaslea;
import org.osb.web.domain.ikaslea.repository.IkasleaRepository;
import org.osb.web.domain.ikaslea.service.IkasleaService;
import org.osb.web.domain.user.repository.UserRepository;

@Service
public class IkasleaServiceImpl implements IkasleaService {

    @Autowired
    private IkasleaRepository ikasleaRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<IkasleaDto> findAllIkasleas() {
        Iterable<Ikaslea> ikasleak = ikasleaRepository.findAll();
        return StreamSupport.stream(ikasleak.spliterator(), false).map(ikaslea -> {
            IkasleaDto ikasleaDto = new IkasleaDto();
            // ikasleaDto.setIzena(ikaslea.getIzena());
            // ikasleaDto.setAbizena(ikaslea.getAbizena());
            // ikasleaDto.setEmail(ikaslea.getEmail());
            // ikasleaDto.setJaiotzeData(ikaslea.getJaiotzeData());
            return ikasleaDto;
        }).collect(Collectors.toList());
    }

    public List<IkasgaiaDto> findIkasgaiakByUser(String username) {

        return userRepository
				.findByEmail(username)
                .map(user -> user.getIkaslea())
				.map(ikaslea -> ikaslea.getKurtsoa().getIkasgaiak()
						.stream()
						.map(ikasgaia -> {
							IkasgaiaDto ikasgaiaDto = new IkasgaiaDto();
                            ikasgaiaDto.setIkasgaiID(ikasgaia.getIkasgaiID());
							ikasgaiaDto.setIzena(ikasgaia.getIzena());
							return ikasgaiaDto;	
						})
						.toList()).orElse(new ArrayList<>());
    }

}