package org.osb.web.domain.apuntea.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.osb.web.domain.apuntea.dto.ApunteaDto;
import org.osb.web.domain.apuntea.model.Apuntea;
import org.osb.web.domain.apuntea.projection.ApunteaProjection;
import org.osb.web.domain.apuntea.repository.ApunteaRepository;
import org.osb.web.domain.apuntea.service.ApunteaService;
import org.osb.web.domain.artxiboa.dto.ArtxiboaDto;
import org.osb.web.domain.artxiboa.model.Artxiboa;
import org.osb.web.domain.artxiboa.repository.ArtxiboaRepository;
import org.osb.web.domain.balorazioa.model.Balorazioa;
import org.osb.web.domain.ikasgaia.repository.IkasgaiaRepository;
import org.osb.web.domain.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApunteaServiceImpl implements ApunteaService {

	@Autowired
	private ApunteaRepository apunteaRepository;
	

	@Autowired
	private UserService userService;

	@Autowired
	private IkasgaiaRepository ikasgaiaRepository;

	@Autowired
	private ArtxiboaRepository artxiboaRepository;

	@Override
	public void saveApuntea(ApunteaDto apunteaDto) {
		Apuntea apuntea = new Apuntea();
		apunteaRepository.save(apuntea);
		apuntea.setIzena(apunteaDto.getIzena());
		apuntea.setIkaslea(userService.findUserByEmail(apunteaDto.getEgileEmail()).orElseThrow().getIkaslea());
		apuntea.setIkasgaia(ikasgaiaRepository.findByIzena(apunteaDto.getIkasgaiIzena()).orElseThrow());
		apuntea.setArtxiboak(
				apunteaDto
						.getArtxiboDtoLista()
						.stream()
						.map(artxiboaDto -> {
							Artxiboa artxiboa = new Artxiboa();
							artxiboa.setIzena(artxiboaDto.getIzena());
							artxiboa.setDokumentua(artxiboaDto.getDatuak());
							artxiboa.setApuntea(apuntea);
							return artxiboaRepository.save(artxiboa);
						})
						.toList());

	}

	@Override
	public Optional<ApunteaDto> findApunteaDtoById(Long id) {
		return apunteaRepository
				.findById(id)
				.map(apuntea -> {
					ApunteaDto apunteaDto = new ApunteaDto();
					apunteaDto.setId(apuntea.getApunteID());
					apunteaDto.setIzena(apuntea.getIzena());
					apunteaDto.setEgileEmail(apuntea.getIkaslea().getUser().getEmail());
					apunteaDto.setIkasgaiIzena(apuntea.getIkasgaia().getIzena());
					apunteaDto.setPuntuazioa(findApunteaPuntuazioaById(id).orElseThrow());
					apunteaDto.setArtxiboDtoLista(
							apuntea
									.getArtxiboak()
									.stream()
									.map(artxiboa -> {
										ArtxiboaDto artxiboaDto = new ArtxiboaDto();
										artxiboaDto.setIzena(artxiboa.getIzena());
										artxiboaDto.setDatuak(artxiboa.getDokumentua());
										return artxiboaDto;
									}).toList());
					return apunteaDto;
				});
	}

	@Override
	public Optional<Integer> findApunteaPuntuazioaById(Long id) {
		int puntuazioa = 0;
		if (apunteaRepository.findById(id).isPresent()) {
			List<Balorazioa> balorazioak = apunteaRepository.findById(id).get().getBalorazioak();
			for (Balorazioa balorazioa : balorazioak) {
				puntuazioa += balorazioa.getBalorazioa();
			}
			return Optional.of(Integer.valueOf(puntuazioa));
		}
		return Optional.empty();
	}

	@Override
	public Optional<Apuntea> findApunteaById(Long id) {
		return apunteaRepository.findById(id);
	}

	@Override
	public List<ApunteaDto> findAllApunteaDto() {
		return StreamSupport
				.stream(apunteaRepository.findAll().spliterator(), false)
				.map(apuntea -> {
					ApunteaDto apunteaDto = new ApunteaDto();
					apunteaDto.setId(apuntea.getApunteID());
					apunteaDto.setIzena(apuntea.getIzena());
					apunteaDto.setEgileEmail(apuntea.getIkaslea().getUser().getEmail());
					apunteaDto.setIkasgaiIzena(apuntea.getIkasgaia().getIzena());
					apunteaDto.setPuntuazioa(findApunteaPuntuazioaById(apuntea.getApunteID()).orElseThrow());
					return apunteaDto;
				})
				.toList();
	}

	@Override
	public List<ApunteaDto> findApunteakInfo() {
		
		return apunteaRepository.findAllApunteaBy().stream().map(apunteaProjection->{
			ApunteaDto apuntea = new ApunteaDto();
			apuntea.setId(apunteaProjection.getApunteID());
			apuntea.setEgileEmail(apunteaProjection.getIkaslea_User_Email());
			apuntea.setIzena(apunteaProjection.getIzena());
			apuntea.setPuntuazioa(findApunteaPuntuazioaById(apunteaProjection.getApunteID()).orElseThrow());
			return apuntea;
		}).toList();
	}

}