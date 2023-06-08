package org.osb.web.domain.apuntea.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApunteaDto {

    private Long apunteID;

    @NotEmpty
    private String izena;

    private int upvotes;

    private int downvotes;

}