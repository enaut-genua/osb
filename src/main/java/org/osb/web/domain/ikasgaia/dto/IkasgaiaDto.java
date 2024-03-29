package org.osb.web.domain.ikasgaia.dto;

import java.util.List;

import org.osb.web.domain.apuntea.dto.ApunteaDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IkasgaiaDto {
	private Long ikasgaiID;
	private String izena;
	private List<ApunteaDto> apunteak;
}