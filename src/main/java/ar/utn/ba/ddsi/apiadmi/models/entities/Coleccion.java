package ar.utn.ba.ddsi.apiadmi.models.entities;

import lombok.Data;

import java.util.List;

@Data
public class Coleccion {

    private String handle;
    private String titulo;
    private String descripcion;
    private Fuente fuente;
    private List<InterfaceCondicion> criterioDePertenencia;
    //private List<Hecho> hechos;


}
