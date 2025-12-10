package ar.utn.ba.ddsi.apiadmi.controllers;

import ar.utn.ba.ddsi.apiadmi.models.dtos.ColeccionDto;
import ar.utn.ba.ddsi.apiadmi.models.entities.hecho.Categoria;
import ar.utn.ba.ddsi.apiadmi.models.repository.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins= "http://localhost:3000")
public class CriteriosController {

    @Autowired
    private ICategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> obtenerColecciones(){

        return this.categoriaRepository.findAll();

    }
}
