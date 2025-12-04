package ar.utn.ba.ddsi.apiadmi.models.dtos.input;
import lombok.Data;


import java.util.List;
@Data
public class ColeccionInput {

    private String titulo;
    private String descripcion;
    private List<Long> fuentes; // son los ids
    private List<CondicionInput> criterios;
    private String algoritmoConcenso;


}


