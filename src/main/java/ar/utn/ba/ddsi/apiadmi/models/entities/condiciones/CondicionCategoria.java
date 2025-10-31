package ar.utn.ba.ddsi.apiadmi.models.entities.condiciones;

import ar.utn.ba.ddsi.apiadmi.models.entities.Hecho;

public class CondicionTitulo extends Criterio{
    private String titulo;
    @Override
    public Boolean cumpleCriterio(Hecho hecho) {
        return titulo.equals(hecho.getTitulo());
    }
}
