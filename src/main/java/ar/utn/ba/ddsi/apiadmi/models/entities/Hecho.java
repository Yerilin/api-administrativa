package ar.utn.ba.ddsi.apiadmi.models.entities;

@Data
public class Hecho {
  private String Titulo;
    private String descripcion;
    private Categoria categoria;
    private LocalDate fecha;
    private LocalDate fechaDeCarga;
    private List<Fuente> fuentes;
    private Ubicacion lugarDeOcurrencia;
    private Fuente fuenteOrigen;
    private EnumEstado estado;
}
