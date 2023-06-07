package org.osb.web.domain.azterketa.dto;

import jakarta.validation.constraints.NotEmpty;
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
    
    @NotEmpty
	private String izena;

}