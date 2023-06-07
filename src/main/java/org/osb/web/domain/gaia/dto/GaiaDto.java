package org.osb.web.domain.gaia.dto;

import jakarta.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GaiaDto {
    
    private Long gaiaID;

    @NotEmpty
    private String izena;

}