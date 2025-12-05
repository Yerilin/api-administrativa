package ar.utn.ba.ddsi.apiadmi.models.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ColeccionDto {
    private String id;
    private String titulo;
    private String descripcion;
    private List<CondicionDTO> criterios ;
    private String algoritmoDeConsenso;


    /*
    public void addFuentes(List<String> fuentes) {
        this.fuentes.addAll(fuentes);
    }

     */


}
