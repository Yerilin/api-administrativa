package ar.utn.ba.ddsi.apiadmi.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class SolicitudEliminacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_solicitud;
    @ManyToOne
    private Hecho hecho;
    @Column(nullable = false)
    private LocalDate fecha;
    @Column(length = 200)
    private String motivo;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EnumEstadoSol estado;

    public SolicitudEliminacion(Hecho hecho, LocalDate fecha, String motivo) {
        this.hecho = hecho;
        this.fecha = fecha;
        this.motivo = motivo;
        this.estado = EnumEstadoSol.PENDIENTE;
    }
}
