package ar.utn.ba.ddsi.apiadmi.models.entities;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Hecho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Titulo;
    private String descripcion;
    @ManyToOne
    private Categoria categoria;
    private LocalDate fecha;
    private LocalDate fechaDeCarga;
    @ManyToOne
    private Fuente origen;
    @ManyToOne
    private Ubicacion lugarDeOcurrencia;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_hecho")
    private EnumEstado estado;
}
