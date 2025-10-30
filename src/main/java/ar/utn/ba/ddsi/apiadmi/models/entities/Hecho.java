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
    private Categoria categoria;
    private LocalDate fecha;
    private LocalDate fechaDeCarga;
    private List<Fuente> fuentes;
    private Ubicacion lugarDeOcurrencia;
    private Fuente fuenteOrigen;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_hecho")
    private EnumEstado estado;
}
