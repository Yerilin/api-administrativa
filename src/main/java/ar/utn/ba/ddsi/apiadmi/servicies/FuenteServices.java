package ar.utn.ba.ddsi.apiadmi.servicies;

import ar.utn.ba.ddsi.apiadmi.models.entities.Fuente;
import ar.utn.ba.ddsi.apiadmi.models.repository.IFuentesRepository;
import ar.utn.ba.ddsi.apiadmi.servicies.interfaces.IFuenteServices;
import org.springframework.stereotype.Service;

@Service
public class FuenteServices implements IFuenteServices {

    private IFuentesRepository repoFuentes;

    /*@Override
    public void agregarFuenteDeColeccion( idFuente) {
        this.repoFuentes.save(idFuente);
    }
*/
    @Override
    public void eliminarFuenteDeColeccion(Fuente unaFuente, Long idColeccion) {
        this.repoFuentes.save(unaFuente, idColeccion);
    }

    @Override
    public Object obtenerPorId(Long id) {
        return 1;
    }
}
