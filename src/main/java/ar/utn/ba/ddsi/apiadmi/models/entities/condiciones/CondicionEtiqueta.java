package ar.utn.ba.ddsi.apiadmi.models.entities.condiciones;

import ar.utn.ba.ddsi.apiadmi.models.entities.Hecho;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("etiqueta")
public class CondicionEtiqueta extends InterfaceCondicion {
    private String nombre;

    @Override
    public boolean cumpleCondicion(Hecho hecho) {
        return hecho.getEtiqueta().getNombre().equals(nombre);
    }

    @Override
    public String getDetail() {
        return "etiqueta: " + nombre;
    }
}