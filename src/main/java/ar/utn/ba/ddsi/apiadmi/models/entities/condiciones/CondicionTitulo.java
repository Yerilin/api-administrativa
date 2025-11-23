package ar.utn.ba.ddsi.apiadmi.models.entities.condiciones;

import ar.utn.ba.ddsi.apiadmi.models.entities.Hecho;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("titulo")
public class CondicionTitulo extends InterfaceCondicion {
    private String titulo;

    //SE REALIZA DE ESTA MANERA PARA NO BUSCAR POR IGUAL SI NO QUE SE MENCIONE
    @Override
    public boolean cumpleCondicion(Hecho hecho) {
        return hecho.getTitulo().toLowerCase().contains(this.titulo.toLowerCase());
    }

    @Override
    public String getDetail() {
        return "titulo: " + titulo;
    }
}