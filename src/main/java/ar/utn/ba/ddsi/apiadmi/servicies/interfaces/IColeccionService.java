package ar.utn.ba.ddsi.apiadmi.servicies.interfaces;

import ar.utn.ba.ddsi.apiadmi.models.dtos.ColeccionDto;
import ar.utn.ba.ddsi.apiadmi.models.dtos.input.ColeccionInput;
import ar.utn.ba.ddsi.apiadmi.models.entities.Coleccion;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface IColeccionService {
    public List<ColeccionDto> obtenerColecciones();
    public void agregar(ColeccionInput coleccion);
    public void elimiar(String id);
    public void eliminar(String idColeccion);
    public void agregarFuenteDeColeccion(Long idFuente, String idColeccion);
    public void eliminarFuenteDeColeccion(Long idFuente, Long idColeccion);
}
