package ar.utn.ba.ddsi.apiadmi.models.entities.condiciones;

import ar.utn.ba.ddsi.apiadmi.models.entities.Etiqueta;
import ar.utn.ba.ddsi.apiadmi.models.entities.Hecho;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("etiqueta")
public class CondicionEtiqueta extends InterfaceCondicion {

    @ManyToOne
    private Etiqueta etiqueta;


    @Override
    public boolean cumpleCondicion(Hecho hecho) {
        return hecho.getEtiqueta().getNombre().equals(this.etiqueta.getNombre());
    }

    @Override
    public String getDetail() {
        return "etiqueta: " + this.etiqueta.getNombre();
    }
}