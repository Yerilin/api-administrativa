package ar.utn.ba.ddsi.apiadmi.servicies;

import ar.utn.ba.ddsi.apiadmi.models.entities.condiciones.Criterio;
import ar.utn.ba.ddsi.apiadmi.models.repository.ICriteriosRepository;
import ar.utn.ba.ddsi.apiadmi.servicies.interfaces.ICriterioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriterioService implements ICriterioService {

    @Autowired
    private ICriteriosRepository repo;

    @Override
    public Criterio buscarPorId(Long Id) {
        Criterio criterio =this.repo.findById(Id)
                .orElseThrow(() -> new RuntimeException("Colección no encontrada"));

        return criterio;
    }
}
