package ar.utn.ba.ddsi.apiadmi.models.dtos.input;
import lombok.Data;


import java.util.List;
@Data
public class ColeccionInput {

    private String id_coleccion;
    private String tituloInput;
    private String descripcionInput;
    private List<Long> fuentesInput; // son los ids
    private List<CondicionInput> criteriosInput;
    private String AlgoritmoConcenso;


}


