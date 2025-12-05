package ar.utn.ba.ddsi.apiadmi.servicies.interfaces;

import ar.utn.ba.ddsi.apiadmi.models.dtos.input.SolicitudInput;

public interface ISolicitudService {


    void actualizarEstado(Long id, SolicitudInput solo);
}
