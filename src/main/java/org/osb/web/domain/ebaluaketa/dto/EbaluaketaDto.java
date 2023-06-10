package org.osb.web.domain.ebaluaketa.dto;

import org.osb.web.domain.ikaslea.model.Ikaslea;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EbaluaketaDto {
	private double nota;
	private Ikaslea ikaslea;
	private String komentarioa;
}