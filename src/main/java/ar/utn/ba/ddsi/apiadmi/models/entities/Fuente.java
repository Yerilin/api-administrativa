package ar.utn.ba.ddsi.apiadmi.models.entities;

import lombok.Data;
import ar.utn.ba.api.models.entities.EnumTipo;
@Data
public class Fuente {

    private Long id;
    private EnumTipo tipo;
    private String nombre ;
    private String enpoint;

    public Fuente(EnumTipo tip, String nom, String fuente){
        this.tipo= tip;
        this.nombre = nom;
        this.enpoint=fuente;
    }
}
