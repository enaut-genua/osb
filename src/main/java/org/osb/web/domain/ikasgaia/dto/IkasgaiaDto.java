package org.osb.web.domain.ikasgaia.dto;

import jakarta.validation.constraints.NotEmpty;

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

    @NotEmpty
	private String izena;

}