package org.osb.web.domain.azterketa.dto;

import org.osb.web.domain.ebaluaketa.dto.EbaluaketaDto;
import org.osb.web.domain.ikasgaia.model.Ikasgaia;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AzterketaDto {

	private Long azterketaID;

	private Ikasgaia ikasgaia;

	private String izena;

	private EbaluaketaDto ebaluaketa;
}