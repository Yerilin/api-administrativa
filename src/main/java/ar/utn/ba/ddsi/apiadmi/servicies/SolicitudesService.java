package ar.utn.ba.ddsi.apiadmi.servicies;

import ar.utn.ba.ddsi.apiadmi.models.dtos.input.SolicitudInput;
import ar.utn.ba.ddsi.apiadmi.models.entities.EnumEstado;
import ar.utn.ba.ddsi.apiadmi.models.entities.EnumEstadoSol;
import ar.utn.ba.ddsi.apiadmi.models.entities.Hecho;
import ar.utn.ba.ddsi.apiadmi.models.entities.SolicitudEliminacion;
import ar.utn.ba.ddsi.apiadmi.models.repository.ISolicitudRepository;
import ar.utn.ba.ddsi.apiadmi.servicies.interfaces.IHechoService;
import ar.utn.ba.ddsi.apiadmi.servicies.interfaces.ISolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitudesService implements ISolicitudService {

    @Autowired
    private ISolicitudRepository solicitudRepo;
    private IHechoService hechoService;

    @Override
    public void actualizarEstado(SolicitudInput solo) {
        SolicitudEliminacion solicitud = this.solicitudRepo.findById(Long.valueOf(solo.getId())).
                orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));

        String estadoInput = solo.getEstado().toUpperCase();
        Hecho hecho = solicitud.getHecho();

        try {
            EnumEstadoSol nuevoEstado = EnumEstadoSol.valueOf(estadoInput);
            solicitud.setEstado(nuevoEstado);
            this.hechoService.actualizarElEstadoDelHecho(hecho,nuevoEstado);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Estado inválido: " + solo.getEstado());
        }

        solicitudRepo.save(solicitud);
    }



}
