package ar.utn.ba.ddsi.apiadmi.servicies;

import ar.utn.ba.ddsi.apiadmi.models.dtos.ColeccionDto;
import ar.utn.ba.ddsi.apiadmi.models.dtos.input.ColeccionInput;
import ar.utn.ba.ddsi.apiadmi.models.entities.Coleccion;
import ar.utn.ba.ddsi.apiadmi.models.entities.Fuente;
import ar.utn.ba.ddsi.apiadmi.models.entities.condiciones.Criterio;
import ar.utn.ba.ddsi.apiadmi.models.factory.ColeccionFactory;
import ar.utn.ba.ddsi.apiadmi.models.factory.CriterioFactory;
import ar.utn.ba.ddsi.apiadmi.models.repository.IColeccionRepository;
import ar.utn.ba.ddsi.apiadmi.servicies.interfaces.IColeccionService;
import ar.utn.ba.ddsi.apiadmi.servicies.interfaces.IFuenteServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ColeccionesServices implements IColeccionService {

    // @Autowired
    private IColeccionRepository colecciones;
    private IFuenteServices fuenteService;
    private ColeccionFactory factory;

    public ColeccionesServices(IColeccionRepository repo, IFuenteServices fuente , ColeccionFactory factory) {
        this.colecciones = repo;
        this.fuenteService = fuente;
        this.factory = factory;
    }


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

//        List<Fuente> fuentes = coleccion.getFuentesInput().stream()
//                .map(obj -> fuenteService.obtenerPorId(obj))
//                .collect(Collectors.toList());

        List<Criterio> criterios = coleccion.getCriteriosInput().stream()
                .map(CriterioFactory::crearCriterio)
                .collect(Collectors.toList());


        Coleccion cole = this.factory.crearColeccion(coleccion);
        cole.setFuente(fuentes);
        cole.setCriteriosDePertenencia(criterios);


        colecciones.save(cole);
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

    @Override
    public void agregarFuenteDeColeccion(Long idFuente, String idColeccion) {

    }

    @Override
    public void eliminarFuenteDeColeccion(Long idFuente, Long idColeccion) {

    }

    //Estos ultimos nos lo hago por que falta definir el mapeo
}
