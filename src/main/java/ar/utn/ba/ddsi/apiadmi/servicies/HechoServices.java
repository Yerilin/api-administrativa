package ar.utn.ba.ddsi.apiadmi.servicies;

import ar.utn.ba.ddsi.apiadmi.utils.EnumEstadoHecho;
import ar.utn.ba.ddsi.apiadmi.utils.EnumEstadoSol;
import ar.utn.ba.ddsi.apiadmi.models.entities.hecho.Hecho;
import ar.utn.ba.ddsi.apiadmi.models.repository.IHechosRepository;
import ar.utn.ba.ddsi.apiadmi.servicies.interfaces.IHechoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HechoServices implements IHechoService {

    @Autowired
    private IHechosRepository repo;

    @Override
    public void actualizarElEstadoDelHecho(Hecho hecho, EnumEstadoSol estado) {

        if (estado == EnumEstadoSol.ACEPTADA) {
            hecho.setEstado(EnumEstadoHecho.DADO_DE_BAJA);
            this.repo.save(hecho);
        }
    }
}
