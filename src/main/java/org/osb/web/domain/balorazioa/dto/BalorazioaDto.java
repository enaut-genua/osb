package org.osb.web.domain.balorazioa.dto;

import org.osb.web.domain.apuntea.dto.ApunteaDto;
import org.osb.web.domain.user.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BalorazioaDto {
	private int balorazioa;
	private ApunteaDto apunteaDto;
	private UserDto userDto;
}
