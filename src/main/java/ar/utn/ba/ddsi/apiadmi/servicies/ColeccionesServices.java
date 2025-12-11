package ar.utn.ba.ddsi.apiadmi.servicies;

import ar.utn.ba.ddsi.apiadmi.models.dtos.ColeccionDto;
import ar.utn.ba.ddsi.apiadmi.models.dtos.CondicionDTO;
import ar.utn.ba.ddsi.apiadmi.models.dtos.input.ColeccionInput;
import ar.utn.ba.ddsi.apiadmi.models.dtos.input.CondicionInput;
import ar.utn.ba.ddsi.apiadmi.models.entities.coleccion.Coleccion;
import ar.utn.ba.ddsi.apiadmi.models.entities.condiciones.*;
import ar.utn.ba.ddsi.apiadmi.models.entities.fuente.Fuente;
import ar.utn.ba.ddsi.apiadmi.models.entities.hecho.Categoria;
import ar.utn.ba.ddsi.apiadmi.models.entities.hecho.Etiqueta;
import ar.utn.ba.ddsi.apiadmi.models.factory.ColeccionFactory;
import ar.utn.ba.ddsi.apiadmi.models.repository.IColeccionRepository;
import ar.utn.ba.ddsi.apiadmi.servicies.interfaces.IColeccionService;
import ar.utn.ba.ddsi.apiadmi.servicies.interfaces.IFuenteServices;
import ar.utn.ba.ddsi.apiadmi.utils.EnumTipoDeAlgoritmo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

    public ColeccionesServices(IColeccionRepository repo, IFuenteServices fuente, ColeccionFactory factory,CondicionService condiciones,CategoriaService serviceCate,EtiquetaService serviceEtiqueta) {
        this.colecciones = repo;
        this.fuenteService = fuente;
        this.coleccionFactory=factory;
        this.condicionService= condiciones;
        this.categoriaService= serviceCate;
        this.etiquetaService = serviceEtiqueta;
    }



    public List<ColeccionDto> obtenerColecciones() {
        return this.colecciones.findAll().stream().map(this::ColeccionDto).toList();
        //if(this.colecciones.findAll().stream().map(this::ColeccionDto).toList();)
    }
/* PARA MOSTRAR TODAS LAS COLECCIONES EN GENERAL*/
    private ColeccionDto ColeccionDto(Coleccion cole) {
        ColeccionDto coleout = new ColeccionDto();
        coleout.setId_coleccion(cole.getId_coleccion());
        coleout.setTitulo(cole.getTitulo());
        coleout.setDescripcion(cole.getDescripcion());
        //coleout.setHandle(cole.getHandle()); /*DEBERIA AGREGARSE*/
        coleout.setCriterios(cole.getCondicionDePertenencia().stream()
                .map(c-> new CondicionDTO(c.getId_condicion(),c.tipo(),c.valor()))
                .collect(Collectors.toList())
        );
        List<Fuente> fuentesInput= new ArrayList<>();
        cole.getFuentes().forEach(fuente -> {
            fuentesInput.add(fuenteService.buscarPorNombre(fuente.getNombre()));
        });
        coleout.setFuentes(fuentesInput);
        coleout.setAlgoritmoDeConsenso(cole.getTipoDeAlgoritmo().toString());
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

        List<Fuente> fuentes = coleccion.getFuentes().stream()
                .map(a -> this.fuenteService.buscarPorNombre(a))
                .collect(Collectors.toList());

        List<InterfaceCondicion> criterios = coleccion.getCriterios().stream()
                .map(a-> this.cargarOCrearCondicion(a))
                .collect(Collectors.toList());


        Coleccion cole = this.coleccionFactory.crearColeccion(coleccion);
        cole.setFuentes(fuentes);
        cole.setTipoDeAlgoritmo(EnumTipoDeAlgoritmo.valueOf(coleccion.getAlgoritmoConcenso()));
        cole.setCondicionDePertenencia(criterios);


        colecciones.save(cole);
    }

    @Transactional
    @Override
    public void actualizar(Long id,ColeccionInput input){

        try {

            Coleccion cole = colecciones.findById(id)
                    .orElseThrow(() -> new RuntimeException("No existe la colección"));
            System.out.println(input);
            cole.setTitulo(input.getTitulo());
            cole.setDescripcion(input.getDescripcion());
            //Actualizacion de algoritmo de concenso
            String algoInput = input.getAlgoritmoConcenso();
            if(algoInput != null) {
            cole.setTipoDeAlgoritmo(EnumTipoDeAlgoritmo.valueOf(input.getAlgoritmoConcenso()));
            }
            // fuentes
            List<Fuente> nuevasFuentes = input.getFuentes().stream()
                    .map(f -> fuenteService.buscarPorNombre(f))
                    .collect(Collectors.toList());
            cole.setFuentes(nuevasFuentes);

            List<InterfaceCondicion> condicionesOriginales = cole.getCondicionDePertenencia();

            List<InterfaceCondicion> nuevasCondiciones = input.getCriterios().stream()
                    .map(this::cargarOCrearCondicion)
                    .collect(Collectors.toList());

            // Eliminar de BD las condiciones borradas
            List<InterfaceCondicion> paraEliminar = condicionesOriginales.stream()
                    .filter(cond -> !nuevasCondiciones.contains(cond))
                    .collect(Collectors.toList());

            for (InterfaceCondicion condicion : paraEliminar) {
                this.condicionService.deleteBy(condicion.getId_condicion());
            }

            // *** PASO IMPORTANTE ***
            // Limpiar relaciones (esto elimina filas de condicion_x_coleccion)
            cole.getCondicionDePertenencia().clear();

            // Agregar las nuevas
            cole.getCondicionDePertenencia().addAll(nuevasCondiciones);
            
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
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate desde = LocalDate.parse(valor, formatter);
                return new CondicionFechaDESPUES(desde);

            case "fechaAntes":
                DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate hasta = LocalDate.parse(valor, formatter1);

                return new CondicionFechaANTES(hasta);

            case "Categoria":
                Categoria categoria= this.categoriaService.buscarPorNombre(valor);
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