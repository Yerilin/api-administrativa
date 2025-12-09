package ar.utn.ba.ddsi.apiadmi.controllers;

import ar.utn.ba.ddsi.apiadmi.models.dtos.ColeccionDto;
import ar.utn.ba.ddsi.apiadmi.models.dtos.input.ColeccionInput;
import ar.utn.ba.ddsi.apiadmi.servicies.ColeccionesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/colecciones")
//@CrossOrigin(origins= "http://localhost:3000")
public class CollecionController {

    @Autowired
    private ColeccionesServices coleccionService;

    /*private  CollecionController(ColeccionesServices coleccionService){

        this.coleccionService= coleccionService;
    }*/

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
    public void actualizarColeccion(@PathVariable Long id , @RequestBody ColeccionInput coleccionInput) {
        //DEBERIA ESTAR DENTRO DE UN TRYCATCH
        this.coleccionService.actualizar(id,coleccionInput);



    }
    @DeleteMapping ("/{id}")
    public void eliminarColeccion(@PathVariable Long id ){

        this.coleccionService.eliminar(id);
    }


}
