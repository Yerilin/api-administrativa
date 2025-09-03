package ar.utn.ba.ddsi.apiadmi.models.repository;

import ar.utn.ba.ddsi.apiadmi.models.entities.Coleccion;

import java.util.List;

public interface IColeccionRepository {

    public void save(Coleccion coleccion);
    public List<Coleccion> findAll();
    public Coleccion findById(Long id);
    public void delete(Coleccion coleccion);

}
