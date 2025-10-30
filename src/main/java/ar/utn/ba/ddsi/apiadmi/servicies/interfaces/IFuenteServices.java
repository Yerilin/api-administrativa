package ar.utn.ba.ddsi.apiadmi.servicies.interfaces;

import ar.utn.ba.ddsi.apiadmi.models.entities.Fuente;

public interface IFuenteServices {

    //public void agregarFuenteDeColeccion(Fuente unaFuente, Long idColeccion);
    public void eliminarFuenteDeColeccion(Fuente unaFuente, Long idColeccion);
    public Fuente buscarPorId(Long id);

}
