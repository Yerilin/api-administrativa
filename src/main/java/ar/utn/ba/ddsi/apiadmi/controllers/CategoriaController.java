package ar.utn.ba.ddsi.apiadmi.controllers;

import ar.utn.ba.ddsi.apiadmi.models.dtos.input.CategoriaDTO;
import ar.utn.ba.ddsi.apiadmi.models.repository.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins= "http://localhost:3000")
public class CategoriaController {

    @Autowired
    private ICategoriaRepository categoriaRepository;

    @GetMapping
    public List<CategoriaDTO> obtenerColecciones(){

        return this.categoriaRepository.findAll()
                .stream()
                .map(categoria -> new CategoriaDTO(categoria.getNombre()))
                .collect(Collectors.toList());

    }
}
