package ar.utn.ba.ddsi.apiadmi.models.entities.condiciones;

import ar.utn.ba.ddsi.apiadmi.models.entities.Hecho;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Entity
@Table(name = "condicion")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)// DISCUTIR POR WHASATP
@DiscriminatorColumn(name = "Condicion", discriminatorType = DiscriminatorType.STRING)
public abstract class InterfaceCondicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public boolean cumpleCondicion(Hecho hecho) {
        return false;
    }

    public abstract String getDetail();
}