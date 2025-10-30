package ar.utn.ba.ddsi.apiadmi.models.entities;

import ar.utn.ba.ddsi.apiadmi.models.entities.condiciones.Criterio;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
public class Coleccion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String handle;
    @Column
    private String titulo;
    @Column
    private String descripcion;
    @ManyToOne
    private List <Fuente> fuentes;
    @ManyToMany
    @JoinTable(
            name = "criterio_x_coleccion",
            joinColumns = @JoinColumn(name = "id_coleccion"),
            inverseJoinColumns = @JoinColumn(name = "id_criterio")
    )
    private List<Criterio> criteriosDePertenencia;

    private List<Hecho> hechos;


    public Coleccion (){}
    public Coleccion(String titulo, String descrip,List<Fuente> fuentes,List <Criterio> criterios){

        this.titulo = titulo;
        this.descripcion= descrip;
        this.fuentes= fuentes;
        this.criteriosDePertenencia=criterios;
    }

    public void addFuente(Fuente fuente){
        this.fuentes.add(fuente);
    }
    public void addCriterio(Criterio criterio){
        this.criteriosDePertenencia.add(criterio);
    }

}
