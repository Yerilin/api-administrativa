package ar.utn.ba.ddsi.apiadmi.models.repository;

import ar.utn.ba.ddsi.apiadmi.models.entities.Fuente;

public interface IFuentesRepository {

    public void save(Fuente unaFuente, Long idColeccion);
    public void delete(Fuente unaFuente, Long idColeccion);
}
