package ar.utn.ba.ddsi.apiadmi.models.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ColeccionDto {
   // private String handle;
    private String titulo;
    private String descripcion;
    private List<CondicionDTO> Condiciones ;


    /*
    public void addFuentes(List<String> fuentes) {
        this.fuentes.addAll(fuentes);
    }

     */


}
