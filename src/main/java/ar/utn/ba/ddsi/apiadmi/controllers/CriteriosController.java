package ar.utn.ba.ddsi.apiadmi.controllers;

import ar.utn.ba.ddsi.apiadmi.models.dtos.input.CriterioInput;
import ar.utn.ba.ddsi.apiadmi.models.entities.condiciones.Criterio;
import ar.utn.ba.ddsi.apiadmi.servicies.CriterioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/criterios")
public class CriteriosController {
    @Autowired
    private final CriterioService criterioService;

    public CriteriosController(CriterioService criterioService) {
        this.criterioService = criterioService;
    }

    @PostMapping
    public ResponseEntity<Criterio> crear(@RequestBody Criterio criterio) {
        Criterio guardado = criterioService.save(criterio);
        return ResponseEntity.ok(guardado);
    }

    @GetMapping
    public ResponseEntity<List<Criterio>> listar() {
        return ResponseEntity.ok(criterioService.findAll());
    }
    @GetMapping("/{id}")
    public Criterio buscarPorId(@PathVariable Long id) {
        return criterioService.buscarPorId(id).get();
    }
    @DeleteMapping("/{id}")
    public void eliminar(@RequestParam Long id) {
        criterioService.deleteBy(id);
    }
}
