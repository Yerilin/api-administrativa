package ar.utn.ba.ddsi.apiadmi.models.dtos;

import ar.utn.ba.ddsi.apiadmi.servicies.CondicionService;
import lombok.Data;

@Data
public class CondicionDTO {
    private Long id;
    private String detail;

    public CondicionDTO(Long id, String Detail){
        this.id = id;
        this.detail = Detail;
    }
}


