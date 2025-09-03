package ar.utn.ba.ddsi.apiadmi.models.dtos.input;
import ar.utn.ba.ddsi.apiadmi.models.dtos.input.Criterio;
import lombok.Data;

import java.util.List;

@Data
public class ColeccionInput {

    private String tituloInput;
    private String descripcionInput;
    private String fuenteInput;
    private List<Criterio> condicionesInput;


}

