package org.osb.web.controller;

import java.util.List;

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

    @MessageMapping("/message")
    @SendTo("/gaiak/notificaciones")
    public List<ArtxiboaProjection> getGaia(Long gaiaId){
        return gaiaService.findData(gaiaId);
    }

}