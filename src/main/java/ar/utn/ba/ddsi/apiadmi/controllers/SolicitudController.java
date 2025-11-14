package ar.utn.ba.ddsi.apiadmi.controllers;

import ar.utn.ba.ddsi.apiadmi.servicies.SolicitudesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ar.utn.ba.ddsi.apiadmi.models.dtos.input.SolicitudInput;
@RestController
@RequestMapping ("/solicitudes")
public class SolicitudController {

    @Autowired
    private SolicitudesService solicitudesService;


    @PutMapping("/{id}")
    public void actualizarEstado(@RequestBody SolicitudInput soli){

        this.solicitudesService.actualizarEstado(soli);


    }

}
