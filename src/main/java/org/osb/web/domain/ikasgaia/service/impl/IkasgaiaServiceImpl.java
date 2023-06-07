package org.osb.web.domain.ikasgaia.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

import org.osb.web.domain.gaia.dto.GaiaDto;
import org.osb.web.domain.ikasgaia.dto.IkasgaiaDto;
import org.osb.web.domain.ikasgaia.model.Ikasgaia;
import org.osb.web.domain.ikasgaia.repository.IkasgaiaRepository;
import org.osb.web.domain.ikasgaia.service.IkasgaiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IkasgaiaServiceImpl implements IkasgaiaService {

	@Autowired
	private IkasgaiaRepository ikasgaiaRepository;

	@Override
	public List<IkasgaiaDto> findAllIkasgaias() {
		Iterable<Ikasgaia> ikasgaiak = ikasgaiaRepository.findAll();

		return StreamSupport.stream(ikasgaiak.spliterator(), false).map(ikasgaia -> {
			IkasgaiaDto ikasgaiaDto = new IkasgaiaDto();
			ikasgaiaDto.setIzena(ikasgaia.getIzena());
			return ikasgaiaDto;
		}).toList();
	}

	@Override
	public List<GaiaDto> findByIkasgaia(String ikasgaiaIzena) {

		return ikasgaiaRepository
				.findByIzena(ikasgaiaIzena)
				.map(ikasgaia -> ikasgaia.getGaiak()
						.stream()
						.map(gaia -> {
							GaiaDto gaiaDto = new GaiaDto();
							gaiaDto.setIzena(gaia.getIzena());
							return gaiaDto;	
						})
						.toList())
				.orElse(new ArrayList<>());
	}

}