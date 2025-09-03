package ar.utn.ba.ddsi.apiadmi.servicies;

import ar.utn.ba.ddsi.apiadmi.models.dtos.ColeccionDto;
import ar.utn.ba.ddsi.apiadmi.models.entities.Coleccion;

import java.util.List;

public interface IColeccionService {

    public void agregar(Coleccion coleccion);
    public List<ColeccionDto> obtenerColecciones();
    public Coleccion encontrarPorId(Long id);
    public void eliminar(Coleccion coleccion);
}
