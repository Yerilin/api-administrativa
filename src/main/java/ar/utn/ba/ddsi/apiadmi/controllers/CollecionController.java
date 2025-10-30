package ar.utn.ba.ddsi.apiadmi.controllers;

import ar.utn.ba.ddsi.apiadmi.models.dtos.ColeccionDto;
import ar.utn.ba.ddsi.apiadmi.models.dtos.input.ColeccionInput;
import ar.utn.ba.ddsi.apiadmi.models.entities.Coleccion;
import ar.utn.ba.ddsi.apiadmi.models.entities.Fuente;
import ar.utn.ba.ddsi.apiadmi.servicies.ColeccionesServices;
import ar.utn.ba.ddsi.apiadmi.servicies.FuenteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/colecciones")
public class CollecionController {

//@Autowired
    private ColeccionesServices coleccionService;

    private  CollecionController(ColeccionesServices coleccionService){

        this.coleccionService= coleccionService;
    }

   @PostMapping
    public void agregarColeccion(@RequestBody ColeccionInput coleccion){


       //Poddria hacer mas validadciones en el futuro
       if(coleccion!=null) {
           this.coleccionService.agregar(coleccion);
       }

    }


    @GetMapping
    public List<ColeccionDto> obtenerColecciones(){

       return this.coleccionService.obtenerColecciones();

    }

    @PutMapping ("/{id}")
    public void actualizarColeccion(@PathVariable String id , @RequestBody ColeccionInput coleccionInput) {

        Coleccion coleccion = coleccionService.actualizar(coleccionInput);
        if(coleccion==null){
            new Error("No se encontro")
        }


    }
    @DeleteMapping ("/{id}")
    public void eliminarColeccion(@PathVariable String id ){

        this.coleccionService.eliminar(id);
    }


}
