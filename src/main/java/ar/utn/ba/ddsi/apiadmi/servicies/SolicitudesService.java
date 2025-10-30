package ar.utn.ba.ddsi.apiadmi.servicies;

import ar.utn.ba.ddsi.apiadmi.models.dtos.input.SolicitudInput;
import ar.utn.ba.ddsi.apiadmi.models.entities.EnumEstado;
import ar.utn.ba.ddsi.apiadmi.models.entities.Hecho;
import ar.utn.ba.ddsi.apiadmi.models.entities.SolicitudEliminacion;
import ar.utn.ba.ddsi.apiadmi.models.repository.ISolicitudRepository;
import ar.utn.ba.ddsi.apiadmi.servicies.interfaces.IHechoService;
import ar.utn.ba.ddsi.apiadmi.servicies.interfaces.ISolicitudService;

public class SolicitudesService implements ISolicitudService {

    private ISolicitudRepository solicitudRepo;
    private IHechoService hechoService;

    @Override
    public void actualizarEstado(SolicitudInput solo) {
        SolicitudEliminacion solicitud = this.solicitudRepo.findById(Long.valueOf(solo.getId())).
                orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));

        String estadoInput = solo.getEstado().toUpperCase();
        Hecho hecho = solicitud.getHecho();

        try {
            EnumEstado nuevoEstado = EnumEstado.valueOf(estadoInput);
            solicitud.setEstado(nuevoEstado);
            this.hechoService.actualizarElEstadoDelHecho(hecho,nuevoEstado);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Estado inválido: " + solo.getEstado());
        }

        solicitudRepo.save(solicitud);
    }



}
