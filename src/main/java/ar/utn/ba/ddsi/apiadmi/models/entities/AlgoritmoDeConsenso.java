package ar.utn.ba.ddsi.apiadmi.models.entities;

import jakarta.persistence.*;

@Entity
public class AlgoritmoDeConsenso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_algoritmo")
    private EnumTipoDeAlgoritmo tipo ;
}
