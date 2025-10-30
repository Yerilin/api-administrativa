package ar.utn.ba.ddsi.apiadmi.models.repository;

import ar.utn.ba.ddsi.apiadmi.models.entities.Fuente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFuentesRepository extends JpaRepository<Fuente, Long> {

    public void save(Fuente unaFuente, Long idColeccion);
    public void delete(Fuente unaFuente, Long idColeccion);
}
