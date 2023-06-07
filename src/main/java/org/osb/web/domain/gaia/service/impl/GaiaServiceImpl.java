package org.osb.web.domain.gaia.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.osb.web.domain.artxiboa.dto.ArtxiboaDto;
import org.osb.web.domain.gaia.dto.GaiaDto;
import org.osb.web.domain.gaia.model.Gaia;
import org.osb.web.domain.gaia.repository.GaiaRepository;
import org.osb.web.domain.gaia.service.GaiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GaiaServiceImpl implements GaiaService {

    @Autowired
    private GaiaRepository gaiaRepository;

    @Override
    public List<GaiaDto> findAllGaias() {
        Iterable<Gaia> gaiak = gaiaRepository.findAll();

        return StreamSupport.stream(gaiak.spliterator(), false).map(gaia -> {
                GaiaDto gaiaDto = new GaiaDto();
                gaiaDto.setIzena(gaia.getIzena());
                return gaiaDto;
            }).collect(Collectors.toList());
    }

    @Override
    public List<ArtxiboaDto> findArtxiboakByGaiaID(Long id) {
        return gaiaRepository
            .findById(id)
            .map(gaia -> gaia.getArtxiboak()
                .stream()
                .map(artxiboa -> {
                    ArtxiboaDto artxiboaDto = new ArtxiboaDto();
                    artxiboaDto.setDokumentua(artxiboa.getDokumentua());
                    return artxiboaDto;
                })
                .toList())
			.orElse(new ArrayList<>());
    }

}