package ar.utn.ba.ddsi.apiadmi.controllers;

import ar.utn.ba.ddsi.apiadmi.servicies.HechoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hechos")
@CrossOrigin(origins= "http://localhost:3000")
public class HechosController {
    @Autowired
    private HechoServices hechoService;

    @PutMapping("/{id}/etiqueta")
    @CrossOrigin(origins= "http://localhost:3000")
    public ResponseEntity<Void> asignarEtiqueta(
            @PathVariable Long id,
            @RequestBody String etiqueta) {

        hechoService.actualizarEtiqueta(id, etiqueta);

        return ResponseEntity.noContent().build(); // 204
    }
}
