package ar.utn.ba.ddsi.apiadmi.models.entities.condiciones;

import ar.utn.ba.ddsi.apiadmi.models.entities.Hecho;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@DiscriminatorValue("TITULO")
public class CondicionTitulo extends Criterio{
    private String titulo;
    @Override
    public Boolean cumpleCriterio(Hecho hecho) {
        return titulo.equals(hecho.getTitulo());
    }
}
