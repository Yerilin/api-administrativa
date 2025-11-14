package ar.utn.ba.ddsi.apiadmi.models.entities;
import jakarta.persistence.*;
import lombok.Data;
import ar.utn.ba.ddsi.apiadmi.models.entities.EnumTipoFuente;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Hecho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_hecho;
    @Column(name = "titulo")
    private String titulo;
    @Column(name="descripcion",length = 1000)
    private String descripcion;
    @ManyToOne
    private Categoria categoria;
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;
    @Column(name = "fechaCarga", nullable = false)
    private LocalDate fechaDeCarga;
    @ManyToOne(cascade = CascadeType.ALL)
    private Fuente fuente;
    @ManyToOne
    private Ubicacion ubicacion;
    @ManyToOne
    private Etiqueta etiqueta;
    @OneToMany
    private List<Adjunto> adjuntos;
    @Transient
    private EnumEstado estado;

    public Hecho(String titulo, String descripcion, Categoria categoria,Ubicacion ubicacion, LocalDate fecha, Fuente fuente) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
        this.fechaDeCarga = LocalDate.now();
        this.etiqueta = null;
        this.fuente = fuente;
        this.estado = EnumEstado.PENDIENTE;
    }

    public Hecho(String titulo, String descripcion, Categoria categoria,Ubicacion ubicacion, LocalDate fecha, Fuente fuente, EnumEstado estado) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
        this.fechaDeCarga = LocalDate.now();
        this.etiqueta = null;
        this.fuente = fuente;
        this.estado = estado;
    }
}
