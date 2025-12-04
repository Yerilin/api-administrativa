package ar.utn.ba.ddsi.apiadmi.controllers;

import ar.utn.ba.ddsi.apiadmi.models.entities.fuente.Fuente;
import ar.utn.ba.ddsi.apiadmi.servicies.SolicitudesService;
import ar.utn.ba.ddsi.apiadmi.servicies.interfaces.IFuenteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fuentes")
public class FuenteController {

    @Autowired
    private IFuenteServices fuenteService;


    @GetMapping
    private List<Fuente> obtenerFuentes(){
        return this.fuenteService.obtenerFuentes();
    }
}
