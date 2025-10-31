package ar.utn.ba.ddsi.apiadmi.servicies.interfaces;

import ar.utn.ba.ddsi.apiadmi.models.entities.condiciones.Criterio;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface ICriterioService {

    Optional<Criterio> buscarPorId(Long Id);
}
