package ar.utn.ba.ddsi.apiadmi.servicies;

import ar.utn.ba.ddsi.apiadmi.models.entities.hecho.Etiqueta;
import ar.utn.ba.ddsi.apiadmi.models.repository.IEtiquetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Long.parseLong;

@Service
public class EtiquetaService {
    @Autowired
    private IEtiquetaRepository etiquetaRepository;

    public Etiqueta buscarPorId(String id) {
        Long identificator = parseLong(id);
        return this.etiquetaRepository.findById(identificator).orElseThrow(() -> new RuntimeException("Etiqueta no encontrada: " + id));
    }

    public List<Etiqueta> obtenerTodas() {
        return etiquetaRepository.findAll();
    }
}
