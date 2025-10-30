package ar.utn.ba.ddsi.apiadmi.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class SolicitudEliminacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private Contribuyente contribuyente;
    private Hecho hecho;
    private LocalDate fecha;
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_coleccion")
    private EnumEstado estado;
    private String motivo ;

}
