package ar.utn.ba.ddsi.apiadmi.servicies.interfaces;

import ar.utn.ba.ddsi.apiadmi.models.dtos.ColeccionDto;
import ar.utn.ba.ddsi.apiadmi.models.dtos.input.ColeccionInput;
import ar.utn.ba.ddsi.apiadmi.models.entities.Coleccion;
import org.springframework.data.jpa.repository.JpaRepository;



import java.util.List;
public interface IColeccionService {
    public List<ColeccionDto> obtenerColecciones();
    public void agregar(ColeccionInput coleccion);
    public Coleccion actualizar(ColeccionInput coleccion);
    public void eliminar(String idColeccion);
    public Coleccion encontrarPorId(String id);
}
