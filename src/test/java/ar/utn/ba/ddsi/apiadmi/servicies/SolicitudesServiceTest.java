package ar.utn.ba.ddsi.apiadmi.servicies;

import ar.utn.ba.ddsi.apiadmi.models.dtos.input.SolicitudInput;
import ar.utn.ba.ddsi.apiadmi.models.entities.EnumEstado;
import ar.utn.ba.ddsi.apiadmi.models.entities.Hecho;
import ar.utn.ba.ddsi.apiadmi.models.entities.SolicitudEliminacion;
import ar.utn.ba.ddsi.apiadmi.models.repository.ISolicitudRepository;
import ar.utn.ba.ddsi.apiadmi.servicies.interfaces.IHechoService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SolicitudesServiceTest {

    @Mock
    private ISolicitudRepository solicitudRepo;

    @Mock
    private IHechoService hechoService;

    @InjectMocks
    private SolicitudesService service;

    private AutoCloseable mocks;

    @BeforeEach
    void setUp(){
        mocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        if (mocks != null) mocks.close();
    }

    @Test
    void actualizarEstado_valido_cambiaYGuarda() {
        SolicitudEliminacion s = new SolicitudEliminacion();
        s.setId(5L);
        Hecho h = new Hecho();
        h.setEstado(EnumEstado.ACEPTADA);
        s.setHecho(h);
        s.setEstado(EnumEstado.PENDIENTE);

        when(solicitudRepo.findById(5L)).thenReturn(Optional.of(s));

        SolicitudInput in = new SolicitudInput();
        in.setId("5");
        in.setEstado("aceptada");

        service.actualizarEstado(in);

        assertEquals(EnumEstado.ACEPTADA, s.getEstado());
        verify(hechoService).actualizarElEstadoDelHecho(h, EnumEstado.ACEPTADA);
        verify(solicitudRepo).save(s);
    }

    @Test
    void actualizarEstado_estadoInvalido_lanza() {
        SolicitudEliminacion s = new SolicitudEliminacion();
        s.setId(6L);
        when(solicitudRepo.findById(6L)).thenReturn(Optional.of(s));

        SolicitudInput in = new SolicitudInput();
        in.setId("6");
        in.setEstado("no_existe");

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> service.actualizarEstado(in));
        assertTrue(ex.getMessage().contains("Estado inválido"));
    }
}
