package ar.utn.ba.ddsi.apiadmi.controllers;

import ar.utn.ba.ddsi.apiadmi.models.entities.admin.SolicitudEliminacion;
import ar.utn.ba.ddsi.apiadmi.servicies.SolicitudesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ar.utn.ba.ddsi.apiadmi.models.dtos.input.SolicitudInput;
@RestController
@RequestMapping ("/solicitudes")
@CrossOrigin(origins= "http://localhost:3000")

public class SolicitudController {

    @Autowired
    private SolicitudesService solicitudesService;


    @PutMapping("/{id}")
    public SolicitudEliminacion actualizarEstado(@PathVariable Long id, @RequestBody SolicitudInput soli){
        return solicitudesService.actualizarEstado(id, soli);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSolicitud(@PathVariable Long id) {
        solicitudesService.eliminarSolicitud(id);
        return ResponseEntity.noContent().build();
    }

}
