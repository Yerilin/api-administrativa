package ar.utn.ba.ddsi.apiadmi.servicies;

import ar.utn.ba.ddsi.apiadmi.models.dtos.ColeccionDto;
import ar.utn.ba.ddsi.apiadmi.models.entities.Coleccion;
import ar.utn.ba.ddsi.apiadmi.models.entities.Fuente;
import ar.utn.ba.ddsi.apiadmi.models.repository.IColeccionRepository;
import org.springframework.boot.autoconfigure.http.client.AbstractHttpRequestFactoryProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColeccionesServices implements IColeccionService {

   // @Autowired
    private IColeccionRepository  colecciones;
    private IFuenteServices fuenteService;

    public ColeccionesServices(IColeccionRepository repo,IFuenteServices fuente){
                this.colecciones=repo;
                this.fuenteService=fuente;
    }


    public List<ColeccionDto> obtenerColecciones(){
       return  this.colecciones.findAll().stream().map(this::ColeccionDto).toList();
    }

    private ColeccionDto ColeccionDto(Coleccion cole) {
        ColeccionDto coleout=new ColeccionDto();
        coleout.setTitulo(cole.getTitulo());
        coleout.setDescripcion(cole.getDescripcion());
        coleout.setHandle(cole.getHandle());
       // coleout.setFuente(String.valueOf(cole.getFuente()));
        return coleout;
    }



    @Override
    public void agregar(Coleccion coleccion) {
        this.colecciones.save(coleccion);
    }



    @Override
    public Coleccion encontrarPorId(Long id) {
        return null;
    }

    @Override
    public void eliminar(Coleccion coleccion) {

    }

//    @Override
//    public void agregarFuenteDeColeccion(Long idFuente) {
//       //Fuente fuente = this.fuenteService.obtenerFuente(idFuente);
//    }

    @Override
    public void eliminarFuenteDeColeccion(Fuente unaFuente, Long idColeccion) {

    }
}
