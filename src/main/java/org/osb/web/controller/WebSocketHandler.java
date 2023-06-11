package org.osb.web.controller;

import java.util.List;

import org.osb.web.domain.apuntea.dto.ApunteaDto;
import org.osb.web.domain.apuntea.service.ApunteaService;
import org.osb.web.domain.artxiboa.projection.ArtxiboaProjection;
import org.osb.web.domain.gaia.service.GaiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketHandler {

    @Autowired
    private GaiaService gaiaService;
    @Autowired
    private ApunteaService apunteaService;

    @MessageMapping("/gaiak")
    @SendTo("/osb/gaiak")
    public List<ArtxiboaProjection> getGaia(Long gaiaId){
        return gaiaService.findData(gaiaId);
    }
    @MessageMapping("/apunteak")
    @SendTo("/osb/apunteak")
    public List<ApunteaDto> getApunteak(){
        return apunteaService.findApunteakInfo();
    }
     @MessageMapping("/apunteak/ikasgaia")
    @SendTo("/osb/apunteak")
    public List<ApunteaDto> getApunteakByIkagaia(Long id){
        return apunteaService.findApunteakInfoByIkasgaia(id);
    }

}