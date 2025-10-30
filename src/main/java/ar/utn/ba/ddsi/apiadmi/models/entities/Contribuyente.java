package ar.utn.ba.ddsi.apiadmi.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Contribuyente {

    @Id
    @GeneratedValue
    @Column(name="id_contribuyente")
    private Long id_contribuyente;
    private String nombre;
    private String apellido;
    private Integer edad;
    private Boolean anonimo;
}
