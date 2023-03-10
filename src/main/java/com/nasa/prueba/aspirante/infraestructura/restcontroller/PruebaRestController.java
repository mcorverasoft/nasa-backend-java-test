package com.nasa.prueba.aspirante.infraestructura.restcontroller;

import com.nasa.prueba.aspirante.dominio.services.NasaService;
import com.nasa.prueba.aspirante.dominio.dto.nasadto.NasaDto;
import com.nasa.prueba.aspirante.dominio.dto.PruebaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("nasa-apolo")
public class PruebaRestController {

    @Autowired
    private NasaService nasaService;
    @GetMapping
    public @ResponseBody ResponseEntity<List<PruebaDto>> getAllNasa(@RequestParam(defaultValue = "0", required = false) int page,
                                                                    @RequestParam(defaultValue = "100", required = false) int size) {
        return ResponseEntity.ok(nasaService.getAllPruebaDTO(page,size));
    }

    /*** Endpoints were comented
    @GetMapping("/info")
    public ResponseEntity<NasaDto> getInfoFromNasaApi(@RequestParam(name="search") String search){
        NasaDto nasainfo=nasaService.getInfoFromNasaApi( search);
        return  ResponseEntity.ok(nasainfo);
    }
    @PostMapping("/info")
    public ResponseEntity<String> getAnSaveInfoFromNasaApi(@RequestParam(name="search") String search){
        Long count=nasaService.getInfoAnSaveFromNasaApi(search);
        return  ResponseEntity.ok(count+ " items saved from Nasa Api");
    }
    */

}
