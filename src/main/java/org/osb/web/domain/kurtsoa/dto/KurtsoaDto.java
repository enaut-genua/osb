package org.osb.web.domain.kurtsoa.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KurtsoaDto {
    
    private Long kurtsoID;

    @NotEmpty
    private String izena;

}