package ar.utn.ba.ddsi.apiadmi.models.factory;


import ar.utn.ba.ddsi.apiadmi.models.entities.Categoria;

import ar.utn.ba.ddsi.apiadmi.models.dtos.input.CondicionInput;
import ar.utn.ba.ddsi.apiadmi.models.entities.Etiqueta;
import ar.utn.ba.ddsi.apiadmi.models.entities.Fuente;
import ar.utn.ba.ddsi.apiadmi.models.entities.condiciones.*;

import ar.utn.ba.ddsi.apiadmi.servicies.CategoriaService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CondicionFactory {


    public InterfaceCondicion crearFechaDespues(LocalDate fecha) {
        return new CondicionFechaDESPUES(fecha);
    }

    public InterfaceCondicion crearFechaAntes(LocalDate fecha) {
        return new CondicionFechaAntes(fecha);
    }

    public InterfaceCondicion crearPorCategoria(String categoria) {
        return new CondicionCategoria(categoria);
    }

    public InterfaceCondicion crearPorEtiqueta(String etiqueta) {
        return new CondicionEtiqueta(etiqueta);
    }

    public InterfaceCondicion crearPorFuente(Fuente fuente) {
        return new CondicionFuente(fuente);
    }
    public InterfaceCondicion crearPorTitulo(String fuente) {
        return new CondicionTitulo(fuente);
    }
}
