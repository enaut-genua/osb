package org.osb.web.domain.gaia.dto;

import java.util.List;

import org.osb.web.domain.artxiboa.dto.ArtxiboaDto;

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

    private String ikasgaiIzena;

    private List<ArtxiboaDto> artxiboDtoLista;

}