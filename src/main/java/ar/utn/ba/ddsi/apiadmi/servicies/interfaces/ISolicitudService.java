package ar.utn.ba.ddsi.apiadmi.servicies.interfaces;

import ar.utn.ba.ddsi.apiadmi.models.dtos.input.SolicitudInput;
import ar.utn.ba.ddsi.apiadmi.models.entities.EnumEstado;

public interface ISolicitudService {

    public void actualizarEstado (SolicitudInput solo);
}
