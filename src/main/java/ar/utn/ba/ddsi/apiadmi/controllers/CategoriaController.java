package ar.utn.ba.ddsi.apiadmi.controllers;

import ar.utn.ba.ddsi.apiadmi.models.dtos.input.CategoriaDTO;
import ar.utn.ba.ddsi.apiadmi.models.repository.ICategoriaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(
        name = "Categorías",
        description = "Endpoints para la gestión de categorías"
)
public class CategoriaController {

    @Autowired
    private ICategoriaRepository categoriaRepository;

    @GetMapping
    @Operation(
            summary = "Obtener todas las categorías",
            description = "Devuelve una lista de categorías disponibles en el sistema"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Listado de categorías obtenido correctamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CategoriaDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "no encontrado"
            )
    })
    public List<CategoriaDTO> obtenerColecciones(){

        return this.categoriaRepository.findAll()
                .stream()
                .map(categoria -> new CategoriaDTO(categoria.getNombre()))
                .collect(Collectors.toList());

    }
}
