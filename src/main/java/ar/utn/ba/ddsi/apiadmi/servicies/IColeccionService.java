package ar.utn.ba.ddsi.apiadmi.servicies;

import ar.utn.ba.ddsi.apiadmi.models.dtos.ColeccionDto;
import ar.utn.ba.ddsi.apiadmi.models.entities.Coleccion;
import ar.utn.ba.ddsi.apiadmi.models.entities.Fuente;

import java.util.List;

public interface IColeccionService {

    public void agregar(Coleccion coleccion);
    public List<ColeccionDto> obtenerColecciones();
    public Coleccion encontrarPorId(Long id);
    public void eliminar(Coleccion coleccion);
    public void agregarFuenteDeColeccion(Fuente unaFuente, Long idColeccion);
    public void eliminarFuenteDeColeccion(Fuente unaFuente, Long idColeccion);
}
