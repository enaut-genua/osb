package org.osb.web.domain.artxiboa.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArtxiboaDto {
    
    private Long artxiboID;

    private String izena;

    @NotEmpty
    private byte[] dokumentua;

}