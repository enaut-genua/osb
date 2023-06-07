package org.osb.web.domain.kurtsoa.service.impl;

import java.util.List;
import java.util.stream.StreamSupport;

import org.osb.web.domain.kurtsoa.dto.KurtsoaDto;
import org.osb.web.domain.kurtsoa.model.Kurtsoa;
import org.osb.web.domain.kurtsoa.repository.KurtsoaRepository;
import org.osb.web.domain.kurtsoa.service.KurtsoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KurtsoaServiceImpl implements KurtsoaService {

	@Autowired
	private KurtsoaRepository kurtsoaRepository;

	@Override
	public List<KurtsoaDto> findAllKurtsoas() {
		Iterable<Kurtsoa> kurtsoak = kurtsoaRepository.findAll();

		return StreamSupport.stream(kurtsoak.spliterator(), false).map(kurtsoa -> {
			KurtsoaDto kurtsoaDto = new KurtsoaDto();
			kurtsoaDto.setIzena(kurtsoa.getIzena());
			return kurtsoaDto;
		}).toList();
	}

}