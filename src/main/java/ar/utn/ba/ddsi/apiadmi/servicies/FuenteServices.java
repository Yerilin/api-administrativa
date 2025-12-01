package ar.utn.ba.ddsi.apiadmi.servicies;

import ar.utn.ba.ddsi.apiadmi.models.entities.fuente.Fuente;
import ar.utn.ba.ddsi.apiadmi.models.repository.IFuentesRepository;
import ar.utn.ba.ddsi.apiadmi.servicies.interfaces.IFuenteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuenteServices implements IFuenteServices {

    @Autowired
    private IFuentesRepository repoFuentes;

    /*@Override
    public void agregarFuenteDeColeccion( idFuente) {
        this.repoFuentes.save(idFuente);
    }
*/

    @Override
    public Fuente buscarPorId(Long id) {
        Fuente fuente = this.repoFuentes.findById(id)
                .orElseThrow(() -> new RuntimeException("Colección no encontrada"));

        return fuente;
    }

}
