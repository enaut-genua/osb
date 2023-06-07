package org.osb.web.domain.irakaslea.dto;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IrakasleaDto {
    
    private Long irakasleID;

    @NotEmpty
    private String izena;

    @NotEmpty
    private String abizena;

    @NotEmpty
    private String email;

    private String pasahitza;

    @NotEmpty
    private Date jaiotzeData;

}