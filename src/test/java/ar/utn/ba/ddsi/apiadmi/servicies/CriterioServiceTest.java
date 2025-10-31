package ar.utn.ba.ddsi.apiadmi.servicies;

import ar.utn.ba.ddsi.apiadmi.models.entities.condiciones.Criterio;
import ar.utn.ba.ddsi.apiadmi.models.repository.ICriteriosRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CriterioServiceTest {

    @Mock
    private ICriteriosRepository repo;

    @InjectMocks
    private CriterioService service;

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
    void buscarPorId_devuelveCriterio() {
        Criterio c = mock(Criterio.class);
        when(repo.findById(10L)).thenReturn(Optional.of(c));

        Optional<Criterio> res = service.buscarPorId(10L);

        assertTrue(res.isPresent());
        assertEquals(c, res.get());
        verify(repo).findById(10L);
    }

    @Test
    void buscarPorId_noExiste_devuelveEmpty() {
        // Configuramos el repo para que devuelva empty
        when(repo.findById(11L)).thenReturn(Optional.empty());

        Optional<Criterio> res = service.buscarPorId(11L);

        assertFalse(res.isPresent());
        verify(repo).findById(11L);
    }
}
