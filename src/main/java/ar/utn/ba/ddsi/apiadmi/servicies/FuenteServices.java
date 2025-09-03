package ar.utn.ba.ddsi.apiadmi.servicies;

import ar.utn.ba.ddsi.apiadmi.models.entities.Fuente;
import ar.utn.ba.ddsi.apiadmi.models.repository.IFuentesRepository;
import org.springframework.stereotype.Service;

@Service
public class FuenteServices implements IFuenteServices{

    private IFuentesRepository repoFuentes;

    @Override
    public void agregarFuenteDeColeccion(Fuente unaFuente, Long idColeccion) {
        this.repoFuentes.save(unaFuente, idColeccion);
    }

    @Override
    public void eliminarFuenteDeColeccion(Fuente unaFuente, Long idColeccion) {
        this.repoFuentes.save(unaFuente, idColeccion);
    }
}
