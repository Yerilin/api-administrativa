package ar.utn.ba.ddsi.apiadmi.models.repository.imp;

import ar.utn.ba.ddsi.apiadmi.models.entities.Coleccion;
import ar.utn.ba.ddsi.apiadmi.models.repository.IColeccionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ColeccionRepositoryMemo implements IColeccionRepository {

    private List<Coleccion> colecciones;
    private Integer numero =0 ;


    @Override
    public void save(Coleccion coleccion) {
        this.numero+=1;
        coleccion.setHandle("Alfanumerico " + String.valueOf(this.numero));
        this.colecciones.add(coleccion);
    }

    @Override
    public List<Coleccion> findAll() {

        return this.colecciones ;
    }

    @Override
    public Coleccion findById(Long id) {
        return null;
    }

    @Override
    public void delete(Coleccion coleccion) {

    }

}
