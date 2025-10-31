package ar.utn.ba.ddsi.apiadmi.models.entities.condiciones;

import ar.utn.ba.ddsi.apiadmi.models.entities.Categoria;
import ar.utn.ba.ddsi.apiadmi.models.entities.Hecho;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@DiscriminatorValue("CATEGORIA")
public class CondicionCategoria extends Criterio{
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    @Override
    public Boolean cumpleCriterio(Hecho hecho) {
        return categoria.equals(hecho.getCategoria());
    }
}
