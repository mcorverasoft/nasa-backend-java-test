package com.nasa.prueba.aspirante.infraestructura.clientrest;

import com.nasa.prueba.aspirante.aplicacion.dto.nasadto.NasaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="nasa-service",url="https://images-api.nasa.gov")
public interface PruebaClienteRest {
    @GetMapping("/search")
    NasaDto getInfo(@RequestParam(name = "q") String search);

}
