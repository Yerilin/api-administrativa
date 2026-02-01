package ar.utn.ba.ddsi.apiadmi.controllers;

import ar.utn.ba.ddsi.apiadmi.models.dtos.ColeccionDto;
import ar.utn.ba.ddsi.apiadmi.models.dtos.input.ColeccionInput;
import ar.utn.ba.ddsi.apiadmi.servicies.ColeccionesServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/colecciones")
@CrossOrigin(origins= "http://localhost:3000")
@Tag(
        name = "Colecciones",
        description = "Endpoints para la gestión de colecciones"
)
public class CollecionController {

    @Autowired
    private ColeccionesServices coleccionService;

    /*private  CollecionController(ColeccionesServices coleccionService){

        this.coleccionService= coleccionService;
    }*/

    @Operation(
            summary = "Crear una nueva colección",
            description = "Agrega una nueva colección al sistema"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Colección creada correctamente"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Datos inválidos en la solicitud"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno del servidor"
            )
    })
   @PostMapping
    public void agregarColeccion(@RequestBody
                                     @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                             description = "Datos de la colección a crear",
                                             required = true,
                                             content = @Content(
                                                     mediaType = "application/json",
                                                     schema = @Schema(implementation = ColeccionInput.class)
                                             )
                                     )
                                     ColeccionInput coleccion){

       //Poddria hacer mas validadciones en el futuro
       if(coleccion!=null) {
           this.coleccionService.agregar(coleccion);
       }

    }

    @Operation(
            summary = "Obtener todas las colecciones",
            description = "Devuelve una lista con todas las colecciones registradas"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Listado de colecciones obtenido correctamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ColeccionDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno del servidor"
            )
    })
    @GetMapping
    public List<ColeccionDto> obtenerColecciones(){

       return this.coleccionService.obtenerColecciones();

    }

    @Operation(
            summary = "Actualizar una colección",
            description = "Actualiza los datos de una colección existente mediante su ID"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Colección actualizada correctamente"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Colección no encontrada"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Datos inválidos"
            )
    })
    @PutMapping ("/{id}")
    public void actualizarColeccion(
            @Parameter(
                    description = "ID de la colección a actualizar",
                    example = "1",
                    required = true
            )@PathVariable Long id ,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos actualizados de la colección",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ColeccionInput.class)
                    )
            )
            @RequestBody ColeccionInput coleccionInput) {
        //DEBERIA ESTAR DENTRO DE UN TRYCATCH
        this.coleccionService.actualizar(id,coleccionInput);



    }
    @Operation(
            summary = "Eliminar una colección",
            description = "Elimina una colección del sistema mediante su ID"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Colección eliminada correctamente"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Colección no encontrada"
            )
    })
    @DeleteMapping ("/{id}")
    public void eliminarColeccion(
            @Parameter(
                    description = "ID de la colección a eliminar",
                    example = "1",
                    required = true
            )
            @PathVariable Long id ){

        this.coleccionService.eliminar(id);
    }


}
