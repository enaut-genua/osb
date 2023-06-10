package org.osb.web.domain.azterketa.service;

import java.util.List;

import org.osb.web.domain.azterketa.dto.AzterketaDto;
import org.osb.web.domain.ebaluaketa.dto.EbaluaketaDto;
import org.osb.web.domain.ikaslea.model.Ikaslea;

public interface AzterketaService {
    List<AzterketaDto> findAllAzterketas();
	List<AzterketaDto> findByIkaslea(Ikaslea ikaslea);
	void saveAzterketa(AzterketaDto azterketaDto, EbaluaketaDto ebaluaketaDto);
	List<AzterketaDto> findByIkalsea(Ikaslea ikaslea);
}