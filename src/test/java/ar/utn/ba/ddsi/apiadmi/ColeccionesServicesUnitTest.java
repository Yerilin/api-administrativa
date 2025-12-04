package ar.utn.ba.ddsi.apiadmi;

import ar.utn.ba.ddsi.apiadmi.models.dtos.input.ColeccionInput;
import ar.utn.ba.ddsi.apiadmi.models.dtos.input.CondicionInput;
import ar.utn.ba.ddsi.apiadmi.models.entities.coleccion.Coleccion;
import ar.utn.ba.ddsi.apiadmi.models.factory.ColeccionFactory;
import ar.utn.ba.ddsi.apiadmi.models.repository.IColeccionRepository;
import ar.utn.ba.ddsi.apiadmi.servicies.*;
import ar.utn.ba.ddsi.apiadmi.servicies.interfaces.IFuenteServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ColeccionesServicesUnitTest {

    private ColeccionesServices servicios;

    @Mock
    private IColeccionRepository repo;
    @Mock
    private IFuenteServices fuenteService;
    @Mock
    private ColeccionFactory factory;
    @Mock
    private CondicionService condicionService;
    @Mock
    private CategoriaService categoriaService;
    @Mock
    private EtiquetaService etiquetaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        servicios = new ColeccionesServices(repo, fuenteService, factory, condicionService, categoriaService, etiquetaService);
    }

    @Test
    void agregar_callsSaveWithCreatedEntity() {
        ColeccionInput input = new ColeccionInput();
        input.setTituloInput("T");
        input.setDescripcionInput("D");
        input.setFuentesInput(List.of(1L));
        input.setCriteriosInput(List.of());
        input.setAlgoritmoConcenso("DEFAULT");

        // factory should create a Coleccion object
        Coleccion cole = new Coleccion();
        when(factory.crearColeccion(input)).thenReturn(cole);
        when(fuenteService.buscarPorId(1L)).thenReturn(null);

        servicios.agregar(input);

        verify(repo, times(1)).save(cole);
    }

    @Test
    void crearCondicion_titulo_createsCondicionTitulo() {
        CondicionInput ci = new CondicionInput();
        ci.setTipo("titulo");
        ci.setValor("algo");

        var condicion = servicios.crearCondicion(ci);
        assertNotNull(condicion);
       // assertEquals("titulo:"+"algo", condicion.getDetail());
    }
}

