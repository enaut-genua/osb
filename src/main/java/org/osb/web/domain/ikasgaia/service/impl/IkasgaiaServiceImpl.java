package org.osb.web.domain.ikasgaia.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.osb.web.domain.apuntea.dto.ApunteaDto;
import org.osb.web.domain.apuntea.service.ApunteaService;
import org.osb.web.domain.artxiboa.dto.ArtxiboaDto;
import org.osb.web.domain.gaia.dto.GaiaDto;
import org.osb.web.domain.gaia.model.Gaia;
import org.osb.web.domain.ikasgaia.dto.IkasgaiaDto;
import org.osb.web.domain.ikasgaia.model.Ikasgaia;
import org.osb.web.domain.ikasgaia.repository.IkasgaiaRepository;
import org.osb.web.domain.ikasgaia.service.IkasgaiaService;

@Service
public class IkasgaiaServiceImpl implements IkasgaiaService {

	@Autowired
	private ApunteaService apunteaService;

	@Autowired
	private IkasgaiaRepository ikasgaiaRepository;

	@Override
	public Optional<IkasgaiaDto> findIkasgaiaDtoByID(Long id) {

		return ikasgaiaRepository
				.findById(id)
				.map(ikasgaia -> {
					IkasgaiaDto ikasgaiaDto = new IkasgaiaDto();
					ikasgaiaDto.setIkasgaiID(ikasgaia.getIkasgaiID());
					ikasgaiaDto.setIzena(ikasgaia.getIzena());
					ikasgaiaDto.setApunteak(
							ikasgaia
									.getApunteak()
									.stream()
									.map(apuntea -> {
										ApunteaDto apunteaDto = new ApunteaDto();
										apunteaDto.setId(apuntea.getApunteID());
										apunteaDto.setIzena(apuntea.getIzena());
										apunteaDto.setEgileEmail(apuntea.getIkaslea().getUser().getEmail());
										apunteaDto.setIkasgaiIzena(apuntea.getIkasgaia().getIzena());
										apunteaDto.setPuntuazioa(apunteaService
												.findApunteaPuntuazioaById(apuntea.getApunteID()).orElseThrow());
										apunteaDto.setArtxiboDtoLista(
												apuntea
														.getArtxiboak()
														.stream()
														.map(artxiboa -> {
															ArtxiboaDto artxiboaDto = new ArtxiboaDto();
															artxiboaDto.setIzena(artxiboa.getIzena());
															artxiboaDto.setDatuak(artxiboa.getDokumentua());
															return artxiboaDto;
														})
														.toList());
										return apunteaDto;
									})
									.toList());
					return ikasgaiaDto;
				});

	}

	@Override
	public List<IkasgaiaDto> findAllIkasgaias() {
		Iterable<Ikasgaia> ikasgaiak = ikasgaiaRepository.findAll();

		return StreamSupport.stream(ikasgaiak.spliterator(), false).map(ikasgaia -> {
			IkasgaiaDto ikasgaiaDto = new IkasgaiaDto();
			ikasgaiaDto.setIzena(ikasgaia.getIzena());
			return ikasgaiaDto;
		}).collect(Collectors.toList());
	}

	@Override
	public List<GaiaDto> findGaiakDtoByIkasgaiaID(Long ikasgaiID) {

		return ikasgaiaRepository
				.findById(ikasgaiID)
				.map(
						ikasgaia -> ikasgaia
								.getGaiak()
								.stream()
								.map(gaia -> {
									GaiaDto gaiaDto = new GaiaDto();
									gaiaDto.setGaiaID(gaia.getGaiaID());
									gaiaDto.setIzena(gaia.getIzena());
									return gaiaDto;
								})
								.toList())
				.orElse(new ArrayList<>());
	}

	@Override
	public List<Gaia> findGaiakByIkasgaiaID(Long ikasgaiID) {
		return ikasgaiaRepository.findById(ikasgaiID).map(ikasgaia -> ikasgaia.getGaiak()).orElse(new ArrayList<>());
	}

	@Override
	public Optional<Ikasgaia> findIkasgaiaByIzena(String izena) {
		return ikasgaiaRepository.findByIzena(izena);
	}

}