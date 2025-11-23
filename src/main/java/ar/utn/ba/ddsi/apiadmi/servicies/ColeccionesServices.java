package ar.utn.ba.ddsi.apiadmi.servicies;

import ar.utn.ba.ddsi.apiadmi.models.dtos.ColeccionDto;
import ar.utn.ba.ddsi.apiadmi.models.dtos.CondicionDTO;
import ar.utn.ba.ddsi.apiadmi.models.dtos.input.ColeccionInput;
import ar.utn.ba.ddsi.apiadmi.models.dtos.input.CondicionInput;
import ar.utn.ba.ddsi.apiadmi.models.entities.*;
import ar.utn.ba.ddsi.apiadmi.models.entities.condiciones.*;
import ar.utn.ba.ddsi.apiadmi.models.factory.ColeccionFactory;
import ar.utn.ba.ddsi.apiadmi.models.repository.IColeccionRepository;
import ar.utn.ba.ddsi.apiadmi.servicies.interfaces.IColeccionService;
import ar.utn.ba.ddsi.apiadmi.servicies.interfaces.IFuenteServices;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Long.parseLong;


@Service
public class ColeccionesServices implements IColeccionService {


    private IColeccionRepository colecciones;
    private IFuenteServices fuenteService;
    private ColeccionFactory coleccionFactory;
    private CategoriaService categoriaService;
    private EtiquetaService etiquetaService;
    private CondicionService condicionService;

    public ColeccionesServices(IColeccionRepository repo, IFuenteServices fuente, ColeccionFactory factory,CondicionService condiciones) {
        this.colecciones = repo;
        this.fuenteService = fuente;
        this.coleccionFactory=factory;
        this.condicionService= condiciones;
    }



    public List<ColeccionDto> obtenerColecciones() {
        return this.colecciones.findAll().stream().map(this::ColeccionDto).toList();
        //if(this.colecciones.findAll().stream().map(this::ColeccionDto).toList();)
    }
/* PARA MOSTRAR TODAS LAS COLECCIONES EN GENERAL*/
    private ColeccionDto ColeccionDto(Coleccion cole) {
        ColeccionDto coleout = new ColeccionDto();
        coleout.setTitulo(cole.getTitulo());
        coleout.setDescripcion(cole.getDescripcion());
        //coleout.setHandle(cole.getHandle()); /*DEBERIA AGREGARSE*/
        coleout.setCondiciones(cole.getCondicionDePertenencia().stream()
                .map(c-> new CondicionDTO(c.getId_condicion(),c.getDetail()))
                .collect(Collectors.toList())
        );
        return coleout;
    }
    /*ESTE PARA PODER TENER TODOS LOS DATOS DE UNA COLECCION EN SI*/
    /*

    private ColeccionDto ColeccionDetailDto(Coleccion cole) {
        ColeccionDto coleout = new ColeccionDto();
        coleout.setTitulo(cole.getTitulo());
        coleout.setDescripcion(cole.getDescripcion());
        //coleout.setHandle(cole.getHandle());
        coleout.setCondiciones(cole.getCondicionDePertenencia().stream()
                .map(InterfaceCondicion::getDetail)
                .collect(Collectors.toList())
        );
//        coleout.addFuentes(
//                cole.getFuentes().stream()
//                        .map(Fuente::getNombre)
//                        .collect(Collectors.toList())
//        );
        return coleout;
    }
     */


    @Override
    public void agregar(ColeccionInput coleccion) {

        List<Fuente> fuentes = coleccion.getFuentesInput().stream()
                .map(a -> this.fuenteService.buscarPorId(a))
                .collect(Collectors.toList());

        List<InterfaceCondicion> criterios = coleccion.getCriteriosInput().stream()
                .map(a-> this.crearCondicion(a))
                .collect(Collectors.toList());


        Coleccion cole = this.coleccionFactory.crearColeccion(coleccion);
        cole.setFuentes(fuentes);
        cole.setCondicionDePertenencia(criterios);


        colecciones.save(cole);
    }

    @Transactional
    @Override
    public void actualizar(Long id,ColeccionInput input){

        try {
            Coleccion cole = colecciones.findById(id)
                    .orElseThrow(() -> new RuntimeException("No existe la colección"));

            cole.setTitulo(input.getTituloInput());
            cole.setDescripcion(input.getDescripcionInput());
            //Actualizacion de algoritmo de concenso
            cole.setTipoDeAlgoritmo(EnumTipoDeAlgoritmo.valueOf(input.getAlgoritmoConcenso()));

            // fuentes
            List<Fuente> nuevasFuentes = input.getFuentesInput().stream()
                    .map(f -> fuenteService.buscarPorId(f))
                    .collect(Collectors.toList());
            cole.setFuentes(nuevasFuentes);

            // condiciones
            List<InterfaceCondicion> nuevasCondiciones = input.getCriteriosInput().stream()
                    .map(this::cargarOCrearCondicion)
                    .collect(Collectors.toList());
            cole.setCondicionDePertenencia(nuevasCondiciones);

            colecciones.save(cole);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public InterfaceCondicion cargarOCrearCondicion(CondicionInput inputCOndicion){
        if (inputCOndicion.getId() != null) {
            return condicionService.buscarPorId(inputCOndicion.getId());
        }
        // la creo según el tipo
        return this.crearCondicion(inputCOndicion);
    }

    @Override
    public Coleccion encontrarPorId(Long id) {

        Coleccion c = colecciones.findById(id)
                .orElseThrow(() -> new RuntimeException("Colección no encontrada"));

        return c;
    }

    @Override
    public void eliminar(Long id) {
        this.colecciones.deleteById(id);


    }

    public InterfaceCondicion crearCondicion(CondicionInput condicionInput) {
        String tipo = condicionInput.getTipo();
        String valor = condicionInput.getValor();
        switch (tipo) {

            case "titulo" :
                //ESTE CASO DEBERIA TRATARSE UN POCO DISTINTO YA QUE SE DEBRIA PODER BUSCAR
                // NO POR IGUAL SI NO QUE LO CONTENGA
                return new CondicionTitulo(valor);


            case "fechaDespues" :
                LocalDate desde = LocalDate.parse(valor);
                return new CondicionFechaDESPUES(desde);

            case "fechaAntes":
                LocalDate hasta = LocalDate.parse(valor);
                return new CondicionFechaANTES(hasta);

            case "categoria":
                Categoria categoria= this.categoriaService.buscarPorId(valor);
                if(categoria!=null) return new CondicionCategoria(categoria);
            case "etiqueta":
                Etiqueta etiqueta =this.etiquetaService.buscarPorId(valor);
                if(etiqueta!=null) return new CondicionEtiqueta(etiqueta);

            case "fuente":
                    Fuente fuente = this.fuenteService.buscarPorId(parseLong(valor));
                    if(fuente!=null) return new CondicionFuente(fuente);
            default :
                throw new IllegalArgumentException("Tipo de condición no soportado: " + tipo);
        }
    }


}