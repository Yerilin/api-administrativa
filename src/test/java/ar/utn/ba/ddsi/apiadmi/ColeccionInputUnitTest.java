package ar.utn.ba.ddsi.apiadmi;

import ar.utn.ba.ddsi.apiadmi.models.dtos.input.ColeccionInput;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ColeccionInputUnitTest {

    @Test
    void gettersAndSetters_work() {
        ColeccionInput input = new ColeccionInput();
        input.setTituloInput("MiTitulo");
        input.setDescripcionInput("Desc");
        input.setFuentesInput(List.of(1L, 2L));
        input.setAlgoritmoConcenso("DEFAULT");

        assertEquals("MiTitulo", input.getTituloInput());
        assertEquals("Desc", input.getDescripcionInput());
        assertEquals(2, input.getFuentesInput().size());
        assertEquals("DEFAULT", input.getAlgoritmoConcenso());
    }
}

