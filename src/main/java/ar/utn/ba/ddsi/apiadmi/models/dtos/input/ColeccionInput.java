package ar.utn.ba.ddsi.apiadmi.models.dtos.input;
import ar.utn.ba.ddsi.apiadmi.models.dtos.input.CriterioInput;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.util.List;
@Data
public class ColeccionInput {


    private String tituloInput;
    private String descripcionInput;
    private List<Long> fuentesInput; // son los ids
    private List<CriterioInput> criteriosInput;

}

