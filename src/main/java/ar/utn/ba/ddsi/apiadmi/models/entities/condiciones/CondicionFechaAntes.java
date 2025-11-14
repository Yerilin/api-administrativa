package ar.utn.ba.ddsi.apiadmi.models.entities.condiciones;


import ar.utn.ba.ddsi.apiadmi.models.entities.Hecho;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("fechaAntes")
public class CondicionFechaAntes extends InterfaceCondicion {
    private LocalDate fechaAntes;

    @Override
    public boolean cumpleCondicion(Hecho hecho) {
        return hecho.getFecha().isBefore(fechaAntes);
    }
    @Override
    public String getDetail() {
        return "fechaAntes: " + fechaAntes.toString();
    }
}