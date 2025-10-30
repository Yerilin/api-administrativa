package ar.utn.ba.ddsi.apiadmi.servicies;

import ar.utn.ba.ddsi.apiadmi.models.dtos.ColeccionDto;
import ar.utn.ba.ddsi.apiadmi.models.dtos.input.ColeccionInput;
import ar.utn.ba.ddsi.apiadmi.models.entities.Coleccion;
import ar.utn.ba.ddsi.apiadmi.models.entities.Fuente;
import ar.utn.ba.ddsi.apiadmi.models.entities.condiciones.Criterio;
import ar.utn.ba.ddsi.apiadmi.models.factory.ColeccionFactory;
import ar.utn.ba.ddsi.apiadmi.models.factory.CriterioFactory;
import ar.utn.ba.ddsi.apiadmi.models.repository.IColeccionRepository;
import ar.utn.ba.ddsi.apiadmi.models.repository.ICriteriosRepository;
import ar.utn.ba.ddsi.apiadmi.servicies.interfaces.IColeccionService;
import ar.utn.ba.ddsi.apiadmi.servicies.interfaces.ICriterioService;
import ar.utn.ba.ddsi.apiadmi.servicies.interfaces.IFuenteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ColeccionesServices implements IColeccionService {

     @Autowired
    private IColeccionRepository colecciones;
    private IFuenteServices fuenteService;
    private ColeccionFactory factory;

    private ICriteriosRepository criteriosRepository;

    /*
    public ColeccionesServices(IColeccionRepository repo, IFuenteServices fuente, ColeccionFactory factory,ICriteriosRepository criterioS) {
        this.colecciones = repo;
        this.fuenteService = fuente;
        this.factory = factory;
        this.criteriosRepository= criterioS;
    }*/


    public List<ColeccionDto> obtenerColecciones() {
        return this.colecciones.findAll().stream().map(this::ColeccionDto).toList();
    }

    private ColeccionDto ColeccionDto(Coleccion cole) {
        ColeccionDto coleout = new ColeccionDto();
        coleout.setTitulo(cole.getTitulo());
        coleout.setDescripcion(cole.getDescripcion());
        coleout.setHandle(cole.getHandle());
        // coleout.setFuente(String.valueOf(cole.getFuente()));
        return coleout;
    }


    @Override
    public void agregar(ColeccionInput coleccion) {

        List<Fuente> fuentes = coleccion.getFuentesInput().stream()
                .map(a -> this.fuenteService.buscarPorId(a))
                .collect(Collectors.toList());

        List<Criterio> criterios = coleccion.getCriteriosInput().stream()
                .map(CriterioFactory::crearCriterio)
                .collect(Collectors.toList());


        Coleccion cole = this.factory.crearColeccion(coleccion);
        cole.setFuentes(fuentes);
        cole.setCriteriosDePertenencia(criterios);


        colecciones.save(cole);
    }

    @Override
    public Coleccion actualizar(ColeccionInput coleccionInput){

        try {
            Coleccion coleccion = this.colecciones.findById(coleccionInput.getHandle())
                    .orElseThrow(() -> new RuntimeException("Colección no encontrada"));

            coleccion.setTitulo(coleccionInput.getTituloInput());
            coleccion.setDescripcion(coleccionInput.getDescripcionInput());
            coleccionInput.getFuentesInput().stream().forEach(a -> coleccion.addFuente(this.fuenteService.buscarPorId(a)));
            //coleccionInput.getCriteriosInput().stream().forEach(a->coleccion.addCriterio(this.criterioService.buscarPorId(Long.valueOf(a))));
            this.colecciones.save(coleccion);
            return coleccion;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Coleccion encontrarPorId(String id) {

        Coleccion c = colecciones.findById(id)
                .orElseThrow(() -> new RuntimeException("Colección no encontrada"));

        return c;
    }

    @Override
    public void eliminar(String handle) {
        this.colecciones.deleteById(handle);


    }
}