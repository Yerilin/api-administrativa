package ar.utn.ba.ddsi.apiadmi.models.factory;

import ar.utn.ba.ddsi.apiadmi.models.dtos.input.ColeccionInput;
import ar.utn.ba.ddsi.apiadmi.models.entities.Coleccion;
import ar.utn.ba.ddsi.apiadmi.models.repository.IFuentesRepository;
import ar.utn.ba.ddsi.apiadmi.servicies.FuenteServices;

public class ColeccionFactory {

    public static Coleccion crearColeccion(ColeccionInput coleccion){

        Coleccion cole= new Coleccion();
        cole.setTitulo(coleccion.getTituloInput());
       // cole.setFuente(IFuentesRepository);
        cole.setDescripcion(coleccion.getDescripcionInput());

    }
}
