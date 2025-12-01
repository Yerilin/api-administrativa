package ar.utn.ba.ddsi.apiadmi.models.entities.condiciones;


import ar.utn.ba.ddsi.apiadmi.models.entities.Hecho;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;

/* Se separa en dos clases para distinguir las condiciones*/
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("fechaAntes")
public class CondicionFechaANTES extends InterfaceCondicion {
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