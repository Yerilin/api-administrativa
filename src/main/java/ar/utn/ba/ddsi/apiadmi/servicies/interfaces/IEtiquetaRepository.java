package ar.utn.ba.ddsi.apiadmi.servicies.interfaces;

import ar.utn.ba.ddsi.apiadmi.models.entities.Categoria;
import ar.utn.ba.ddsi.apiadmi.models.entities.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEtiquetaRepository  extends JpaRepository<Etiqueta,Long> {
    Optional<Categoria> findByNombre(String nombre);
}
