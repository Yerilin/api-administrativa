package ar.utn.ba.ddsi.apiadmi.servicies.interfaces;


import ar.utn.ba.ddsi.apiadmi.models.entities.EnumEstadoSol;
import ar.utn.ba.ddsi.apiadmi.models.entities.Hecho;

public interface IHechoService {

    void actualizarElEstadoDelHecho(Hecho hecho, EnumEstadoSol estado);
}
