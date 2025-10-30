package ar.utn.ba.ddsi.apiadmi.models.repository;

import ar.utn.ba.ddsi.apiadmi.models.entities.Coleccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IColeccionRepository extends JpaRepository<Coleccion,String> {

    // Buscar colección por título exacto
    Coleccion findByTitulo(String titulo);

    // Buscar colecciones cuyo título contenga un texto (sin distinción de mayúsculas)
    List<Coleccion> findByTituloContainingIgnoreCase(String texto);

    // Buscar colecciones por descripción parcial
    List<Coleccion> findByDescripcionContainingIgnoreCase(String texto);



}
