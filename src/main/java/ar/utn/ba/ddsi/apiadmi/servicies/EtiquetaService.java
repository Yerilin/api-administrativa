package ar.utn.ba.ddsi.apiadmi.servicies;

import ar.utn.ba.ddsi.apiadmi.models.entities.Etiqueta;
import ar.utn.ba.ddsi.apiadmi.servicies.interfaces.IEtiquetaRepository;
import org.springframework.stereotype.Service;

import static java.lang.Long.parseLong;

@Service
public class EtiquetaService {

    private IEtiquetaRepository etiquetaRepository;
    public Etiqueta buscarPorId(String id) {
        Long identificator = parseLong(id);
        return this.etiquetaRepository.findById(identificator).orElseThrow(() -> new RuntimeException("Etiqueta no encontrada: " + id));
    }
}
