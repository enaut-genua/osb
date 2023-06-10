package org.osb.web.domain.gaia.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.osb.web.domain.artxiboa.dto.ArtxiboaDto;
import org.osb.web.domain.artxiboa.model.Artxiboa;
import org.osb.web.domain.artxiboa.repository.ArtxiboaRepository;
import org.osb.web.domain.gaia.dto.GaiaDto;
import org.osb.web.domain.gaia.model.Gaia;
import org.osb.web.domain.gaia.repository.GaiaRepository;
import org.osb.web.domain.gaia.service.GaiaService;
import org.osb.web.domain.ikasgaia.repository.IkasgaiaRepository;

@Service
public class GaiaServiceImpl implements GaiaService {

    @Autowired
    private GaiaRepository gaiaRepository;

    @Autowired
	private ArtxiboaRepository artxiboaRepository;

    @Autowired
    private IkasgaiaRepository ikasgaiaRepository;

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
                    artxiboaDto.setIzena(artxiboa.getIzena());
					artxiboaDto.setDatuak(artxiboa.getDokumentua());
					artxiboaDto.setArtxiboID(artxiboa.getArtxiboID());
                    return artxiboaDto;
                })
                .toList()).orElse(new ArrayList<>());
    }

    @Override
    public List<ArtxiboaDto> findLehenengoGaiarenArtxiboak(List<Gaia> gaiak) {

        return gaiak.get(0).getArtxiboak().stream().map(artxiboa -> {
            ArtxiboaDto artxiboaDto = new ArtxiboaDto();
            artxiboaDto.setIzena(artxiboa.getIzena());
            artxiboaDto.setDatuak(artxiboa.getDokumentua());
            artxiboaDto.setArtxiboID(artxiboa.getArtxiboID());
            return artxiboaDto; }
        ).collect(Collectors.toList());

    }

    @Override
	public void saveGaia(GaiaDto gaiaDto) {
		Gaia gaia = new Gaia();
		gaia.setIzena(gaiaDto.getIzena());
		gaia.setIkasgaia(ikasgaiaRepository.findByIzena(gaiaDto.getIkasgaiIzena()).get());
		gaiaRepository.save(gaia);
		gaiaDto.getArtxiboDtoLista().forEach((artxiboa) -> {
			Artxiboa artxiboaNew = new Artxiboa();
			artxiboaNew.setDokumentua(artxiboa.getDatuak());
			artxiboaNew.setIzena(artxiboa.getIzena());
			artxiboaNew.setGaia(gaia);
			artxiboaRepository.save(artxiboaNew);
		});
		// gaia.setArtxiboak(converter(artxiboList));
	}

}