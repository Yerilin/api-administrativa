package ar.utn.ba.ddsi.apiadmi.models.entities.condiciones;

import ar.utn.ba.ddsi.apiadmi.models.entities.Categoria;
import ar.utn.ba.ddsi.apiadmi.models.entities.Hecho;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("categoria")
public class CondicionCategoria extends InterfaceCondicion {
    @ManyToOne
    private Categoria categoria; /// creo que es mas sencillo asi

    @Override
    public boolean cumpleCondicion(Hecho hecho) {
        return hecho.getCategoria().getNombre().equals(this.categoria.getNombre());
    }

    @Override
    public String getDetail() {
        return "categoria: " + this.categoria.getNombre();
    }
}