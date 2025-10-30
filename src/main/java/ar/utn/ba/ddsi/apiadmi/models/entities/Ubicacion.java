package ar.utn.ba.ddsi.apiadmi.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Ubicacion {
    @Id
    @GeneratedValue
    private Long id;
    private float latitud;
    private float longitud;

}
