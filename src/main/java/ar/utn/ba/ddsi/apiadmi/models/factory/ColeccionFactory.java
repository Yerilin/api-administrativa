package ar.utn.ba.ddsi.apiadmi.models.factory;

import ar.utn.ba.ddsi.apiadmi.models.dtos.input.ColeccionInput;
import ar.utn.ba.ddsi.apiadmi.models.entities.Coleccion;
import ar.utn.ba.ddsi.apiadmi.models.entities.Fuente;
import ar.utn.ba.ddsi.apiadmi.models.entities.condiciones.Criterio;
import ar.utn.ba.ddsi.apiadmi.models.repository.IFuentesRepository;
import ar.utn.ba.ddsi.apiadmi.servicies.FuenteServices;

import java.util.List;
import java.util.stream.Collectors;

public class ColeccionFactory {

    public Coleccion crearColeccion(ColeccionInput coleccion){

        Coleccion cole = new Coleccion();
        cole.setTitulo(coleccion.getTituloInput());
        cole.setDescripcion(coleccion.getDescripcionInput());
        // NOTA: las fuentes y criterios se setean después desde el Service
        return cole;
    }
}
