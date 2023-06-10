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
import org.osb.web.domain.ebaluaketa.dto.EbaluaketaDto;
import org.osb.web.domain.ebaluaketa.model.Ebaluaketa;
import org.osb.web.domain.ebaluaketa.repository.EbaluaketaRepository;
import org.osb.web.domain.ikaslea.model.Ikaslea;

@Service
public class AzterketaServiceImpl implements AzterketaService {

	@Autowired
	private AzterketaRepository azterketaRepository;

	@Autowired
	private EbaluaketaRepository ebaluaketaRepository;

	@Override
	public List<AzterketaDto> findAllAzterketas() {
		Iterable<Azterketa> azterketak = azterketaRepository.findAll();

		return StreamSupport.stream(azterketak.spliterator(), false).map(azterketa -> {
			AzterketaDto azterketaDto = new AzterketaDto();
			azterketaDto.setIzena(azterketa.getIzena());
			return azterketaDto;
		}).collect(Collectors.toList());
	}

	@Override
	public List<AzterketaDto> findByIkaslea(Ikaslea ikaslea) {
		List<Ebaluaketa> ebaluaketak = ebaluaketaRepository.findByIkaslea(ikaslea);
		return ebaluaketak.stream().map(ebaluaketa -> {
			EbaluaketaDto ebaluaketaDto = new EbaluaketaDto();
			ebaluaketaDto.setIkaslea(ebaluaketa.getIkaslea());
			ebaluaketaDto.setKomentarioa(ebaluaketa.getKomentarioa());
			ebaluaketaDto.setNota(ebaluaketa.getNota());

			Azterketa azterketa = azterketaRepository.findByEbaluaketak(ebaluaketa);

			AzterketaDto azterketaDto = new AzterketaDto();
			azterketaDto.setAzterketaID(azterketa.getAzterketaID());
			azterketaDto.setEbaluaketa(ebaluaketaDto);
			azterketaDto.setIkasgaia(azterketa.getIkasgaia());
			azterketaDto.setIzena(azterketa.getIzena());
			return azterketaDto;
		}).toList();
	}

	@Override
	public void saveAzterketa(AzterketaDto azterketaDto, EbaluaketaDto ebaluaketaDto) {
		Azterketa azterketa = new Azterketa();
		azterketa.setIzena(azterketaDto.getIzena());
		azterketa.setIkasgaia(azterketaDto.getIkasgaia());
		azterketaRepository.save(azterketa);

		Ebaluaketa ebaluaketa = new Ebaluaketa();
		ebaluaketa.setIkaslea(ebaluaketaDto.getIkaslea());
		ebaluaketa.setKomentarioa(ebaluaketaDto.getKomentarioa());
		ebaluaketa.setAzterketa(azterketa);
		ebaluaketa.setNota(ebaluaketaDto.getNota());
		ebaluaketaRepository.save(ebaluaketa);
	}

	@Override
	public List<AzterketaDto> findByIkalsea(Ikaslea ikaslea) {
		List<Ebaluaketa> ebaluaketak = ebaluaketaRepository.findByIkaslea(ikaslea);
		return ebaluaketak.stream().map(ebaluaketa -> {
			EbaluaketaDto ebaluaketaDto = new EbaluaketaDto();
			ebaluaketaDto.setIkaslea(ebaluaketa.getIkaslea());
			ebaluaketaDto.setKomentarioa(ebaluaketa.getKomentarioa());
			ebaluaketaDto.setNota(ebaluaketa.getNota());

			Azterketa azterketa = azterketaRepository.findByEbaluaketak(ebaluaketa);

			AzterketaDto azterketaDto = new AzterketaDto();
			azterketaDto.setAzterketaID(azterketa.getAzterketaID());
			azterketaDto.setEbaluaketa(ebaluaketaDto);
			azterketaDto.setIkasgaia(azterketa.getIkasgaia());
			azterketaDto.setIzena(azterketa.getIzena());
			return azterketaDto;
		}).toList();
	}

}