package ar.utn.ba.ddsi.apiadmi.models.factory;

import ar.utn.ba.ddsi.apiadmi.models.entities.condiciones.Criterio;
import ar.utn.ba.ddsi.apiadmi.models.entities.condiciones.CondicionEntreFechas;
import ar.utn.ba.ddsi.apiadmi.models.dtos.input.CriterioInput;
import ar.utn.ba.ddsi.apiadmi.models.entities.condiciones.Criterio;

import java.time.LocalDate;
import java.util.Map;

public class CriterioFactory {

    public static Criterio crearCriterio(CriterioInput criterioInput) {
        String tipo = criterioInput.getTipo();
        Object valores = criterioInput.getValor();
        switch (tipo) {
            case "FechaEntre" :
                Map<String, String> rango = (Map<String, String>) criterioInput.getValor();

                String desdeStr = rango.get("desde");
                String hastaStr = rango.get("hasta");

                LocalDate desde = LocalDate.parse(desdeStr);
                LocalDate hasta = LocalDate.parse(hastaStr);

                return new CondicionEntreFechas(desde,hasta);

            default :
                return new CondicionEntreFechas(LocalDate.parse("12-03-24"),LocalDate.parse("12-04-24"));
        }
    }

}
