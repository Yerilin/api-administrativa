package ar.utn.ba.ddsi.apiadmi.models.entities.condiciones;

import ar.utn.ba.ddsi.apiadmi.models.entities.Hecho;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@DiscriminatorValue("ENTRE_FECHAS")
public class CondicionEntreFechas extends Criterio {

    private LocalDate desde;
    private LocalDate hasta;

    public CondicionEntreFechas(LocalDate desde ,LocalDate hasta ){

        this.desde = desde;
        this.hasta= hasta;
    }

    @Override
    public Boolean cumpleCriterio(Hecho hecho) {
        //TODO

        return true;
    }

}
