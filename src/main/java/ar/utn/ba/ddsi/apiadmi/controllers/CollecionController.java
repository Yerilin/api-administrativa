package ar.utn.ba.ddsi.apiadmi.controllers;

import ar.utn.ba.ddsi.apiadmi.models.dtos.ColeccionDto;
import ar.utn.ba.ddsi.apiadmi.models.dtos.input.ColeccionInput;
import ar.utn.ba.ddsi.apiadmi.servicies.ColeccionesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/colecciones")
public class CollecionController {

    @Autowired
    private ColeccionesServices coleccionService;

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
    public void actualizarColeccion(@RequestParam String id , @RequestBody ColeccionInput coleccion){

    }

    @DeleteMapping ("/{id}")
    public void eliminarColeccion(@RequestParam String id ){

        this.coleccionService.eliminar(id);
    }

    @PutMapping ("/{id}")
    public void modificacionAlgoritmoDeConcenso(@RequestParam String id ){


    }
}
