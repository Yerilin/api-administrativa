package ar.utn.ba.ddsi.apiadmi.models.entities;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class Fuente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_fuente")
    private EnumTipo tipo;
    private String nombre ;
    private String enpoint;

    public Fuente(EnumTipo tip, String nom, String fuente){
        this.tipo= tip;
        this.nombre = nom;
        this.enpoint=fuente;
    }
}
