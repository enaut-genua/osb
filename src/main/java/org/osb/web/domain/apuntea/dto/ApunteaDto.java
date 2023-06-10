package org.osb.web.domain.apuntea.dto;

import java.util.List;

import org.osb.web.domain.artxiboa.dto.ArtxiboaDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApunteaDto {
	private Long id;
	private String izena;
	private String egileEmail;
	private String ikasgaiIzena;
	private int puntuazioa;
	private List<ArtxiboaDto> artxiboDtoLista;
}