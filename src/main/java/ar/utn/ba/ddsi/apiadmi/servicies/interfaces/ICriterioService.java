package ar.utn.ba.ddsi.apiadmi.servicies.interfaces;

import ar.utn.ba.ddsi.apiadmi.models.entities.condiciones.Criterio;
import org.springframework.stereotype.Service;


public interface ICriterioService {
    Criterio buscarPorId(Long Id);
}
