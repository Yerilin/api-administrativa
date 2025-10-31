package ar.utn.ba.ddsi.apiadmi.servicies;

import ar.utn.ba.ddsi.apiadmi.models.entities.EnumEstado;
import ar.utn.ba.ddsi.apiadmi.models.entities.Hecho;
import ar.utn.ba.ddsi.apiadmi.models.repository.IHechosRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HechoServicesTest {

    @Mock
    private IHechosRepository repo;

    @InjectMocks
    private HechoServices service;

    private AutoCloseable mocks;

    @BeforeEach
    void setUp() {
        mocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        if (mocks != null) mocks.close();
    }

    @Test
    void actualizarElEstadoDelHecho_cambiaEstadoCuandoEsAceptada() {
        Hecho h = new Hecho();
        h.setEstado(EnumEstado.ACEPTADA);

        service.actualizarElEstadoDelHecho(h, EnumEstado.ACEPTADA);

        // Esperamos que el estado cambie a DADO_DE_BAJA y se guarde
        assertEquals(EnumEstado.DADO_DE_BAJA, h.getEstado());
        verify(repo, times(1)).save(h);
    }

    @Test
    void actualizarElEstadoDelHecho_noHaceNadaParaOtrosEstados() {
        Hecho h = new Hecho();
        h.setEstado(EnumEstado.DADO_DE_BAJA);

        service.actualizarElEstadoDelHecho(h, EnumEstado.DADO_DE_BAJA);

        // No se debe llamar a save
        verify(repo, never()).save(any());
    }
}
