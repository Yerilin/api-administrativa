package ar.utn.ba.ddsi.apiadmi.models.dtos.input;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColeccionInput {

    private String titulo;
    private String descripcion;
    private List<String> fuentes; // son los nombres de las fuentes
    private List<CondicionInput> criterios;
    private String algoritmoConcenso;


}


