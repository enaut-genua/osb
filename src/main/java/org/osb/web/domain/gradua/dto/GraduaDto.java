package org.osb.web.domain.gradua.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GraduaDto {
    
    private Long graduID;

    @NotEmpty
    private String izena;

}