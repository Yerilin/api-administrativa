package ar.utn.ba.ddsi.apiadmi.servicies;

import ar.utn.ba.ddsi.apiadmi.models.entities.EnumEstado;
import ar.utn.ba.ddsi.apiadmi.models.entities.Hecho;
import ar.utn.ba.ddsi.apiadmi.models.repository.IHechosRepository;
import ar.utn.ba.ddsi.apiadmi.servicies.interfaces.IHechoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HechoServices implements IHechoService {

    @Autowired
    private IHechosRepository repo;

    @Override
    public void actualizarElEstadoDelHecho(Hecho hecho, EnumEstado estado) {

        if (estado == EnumEstado.ACEPTADA) {
            hecho.setEstado(EnumEstado.DADO_DE_BAJA);
            this.repo.save(hecho);
        }
    }
}
