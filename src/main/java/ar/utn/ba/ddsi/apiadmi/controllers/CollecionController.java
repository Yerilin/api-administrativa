package ar.utn.ba.ddsi.apiadmi.controllers;

import ar.utn.ba.ddsi.apiadmi.models.dtos.ColeccionDto;
import ar.utn.ba.ddsi.apiadmi.models.dtos.input.ColeccionInput;
import ar.utn.ba.ddsi.apiadmi.models.entities.Coleccion;
import ar.utn.ba.ddsi.apiadmi.models.factory.ColeccionFactory;
import ar.utn.ba.ddsi.apiadmi.servicies.IColeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/colecciones")
public class CollecionController {

    @Autowired
    private IColeccionService coleccionService;

   @PostMapping
    public void agregarColeccion(@RequestBody ColeccionInput coleccion){

       Coleccion cole = ColeccionFactory.crearColeccion(coleccion);

        this.coleccionService.agregar(cole);


    }


    @GetMapping
    public List<ColeccionDto> obtenerColecciones(){

       return this.coleccionService.obtenerColecciones();

    }

    @DeleteMapping
    public void eliminarColeccion(String id )

}
