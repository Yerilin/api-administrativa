package ar.utn.ba.ddsi.apiadmi.models.entities;

import lombok.Data;

@Data
public class Fuente {

    //private Long id;          ATRIBUTOS A DISCUTIR
    //private EnumTipo tipo;
    private String enpoint;

    public Fuente(String fuente){
        this.enpoint=fuente;
    }
}
