package ar.utn.ba.ddsi.apiadmi.models.repository;

import ar.utn.ba.ddsi.apiadmi.models.entities.AlgoritmoDeConsenso;
import ar.utn.ba.ddsi.apiadmi.models.repository.imp.AlgConcensoRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAlgConcensoRepository extends JpaRepository<AlgoritmoDeConsenso, Long> {

    Optional<AlgoritmoDeConsenso> findById(Long id);

}
