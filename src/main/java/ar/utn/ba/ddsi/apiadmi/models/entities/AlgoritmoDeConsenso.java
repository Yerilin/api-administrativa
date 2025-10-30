package ar.utn.ba.ddsi.apiadmi.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AlgoritmoDeConsenso {

    @Id
    private Long id;

    @Column
    private String algoritmo ;
}
