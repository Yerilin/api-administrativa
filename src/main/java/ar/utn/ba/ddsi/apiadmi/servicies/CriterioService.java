package ar.utn.ba.ddsi.apiadmi.servicies;

import ar.utn.ba.ddsi.apiadmi.models.entities.condiciones.Criterio;
import ar.utn.ba.ddsi.apiadmi.models.repository.ICriteriosRepository;
import ar.utn.ba.ddsi.apiadmi.servicies.interfaces.ICriterioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CriterioService implements ICriterioService {

    @Autowired
    private ICriteriosRepository repo;

    public Criterio save(Criterio c) {
        return repo.save(c);
    }
    @Override
    public Optional<Criterio> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public List<Criterio> findAll() {
        return repo.findAll();
    }
    public void deleteBy(Long id) {
        repo.deleteById(id);
    }
}
/*http://localhost:8081/api_admi/criterios
{
  "tipo": "ENTRE_FECHAS",
  "desde": "2024-01-01",
  "hasta": "2024-12-31"
}
 */
