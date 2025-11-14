package ar.utn.ba.ddsi.apiadmi.models.entities.condiciones;

import ar.utn.ba.ddsi.apiadmi.models.entities.Fuente;
import ar.utn.ba.ddsi.apiadmi.models.entities.Hecho;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("fuente")
public class CondicionFuente extends InterfaceCondicion {

    @ManyToOne
    @JoinColumn(name = "fuente_id_fuente")
    private Fuente fuente;

    @Override
    public boolean cumpleCondicion(Hecho hecho) {
        return fuente.equals(hecho.getFuente());
    }

    @Override
    public String getDetail() {
        return "fuente: " + fuente.getNombre();
    }
}