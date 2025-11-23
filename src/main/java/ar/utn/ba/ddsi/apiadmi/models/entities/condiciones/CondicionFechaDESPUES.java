package ar.utn.ba.ddsi.apiadmi.models.entities.condiciones;

import ar.utn.ba.ddsi.apiadmi.models.entities.Hecho;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("fechaDespues")
public class CondicionFechaDESPUES extends InterfaceCondicion {
    private LocalDate fechaDespues;

    @Override
    public boolean cumpleCondicion(Hecho hecho) {
        return hecho.getFecha().isAfter(fechaDespues);
    }

    @Override
    public String getDetail() {
        return "fechaDespues: " + fechaDespues.toString();
    }
}

