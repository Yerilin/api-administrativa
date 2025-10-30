package ar.utn.ba.ddsi.apiadmi.servicies;

import ar.utn.ba.ddsi.apiadmi.models.entities.EnumEstado;
import ar.utn.ba.ddsi.apiadmi.models.repository.ISolicitudRepository;
import ar.utn.ba.ddsi.apiadmi.servicies.interfaces.ISolicitudService;

public class SolicitudesService implements ISolicitudService {

    private ISolicitudRepository solicitudRepo;
    //private IHechosRepository hechoRepository

    @Override
    public void updateEstado(Long id, EnumEstado estado) {

    }

}
