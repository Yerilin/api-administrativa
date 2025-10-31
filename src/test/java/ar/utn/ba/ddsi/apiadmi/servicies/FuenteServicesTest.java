package ar.utn.ba.ddsi.apiadmi.servicies;

import ar.utn.ba.ddsi.apiadmi.models.entities.Fuente;
import ar.utn.ba.ddsi.apiadmi.models.repository.IFuentesRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FuenteServicesTest {

    @Mock
    private IFuentesRepository repo;

    @InjectMocks
    private FuenteServices service;

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
    void buscarPorId_devuelveFuenteCuandoExiste() {
        Fuente f = new Fuente(null, "Nombre", "http://endpoint");
        when(repo.findById(1L)).thenReturn(Optional.of(f));

        Fuente res = service.buscarPorId(1L);

        assertNotNull(res);
        assertEquals("Nombre", res.getNombre());
        verify(repo).findById(1L);
    }

    @Test
    void buscarPorId_lanzaCuandoNoExiste() {
        when(repo.findById(2L)).thenReturn(Optional.empty());

        Exception ex = assertThrows(RuntimeException.class, () -> service.buscarPorId(2L));
        assertTrue(ex.getMessage().contains("Colección no encontrada"));
    }
}
