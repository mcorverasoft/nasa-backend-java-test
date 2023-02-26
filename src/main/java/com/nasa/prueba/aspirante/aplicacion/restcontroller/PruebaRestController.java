package com.nasa.prueba.aspirante.aplicacion.restcontroller;

import com.nasa.prueba.aspirante.aplicacion.dto.BaseResponse;
import com.nasa.prueba.aspirante.dominio.services.NasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("nasa-apolo")
public class PruebaRestController {

    @Autowired
    private NasaService nasaService;
    @GetMapping
    public @ResponseBody ResponseEntity<BaseResponse> getAllNasa(@RequestParam(defaultValue = "0", required = false) int page,
                                                                 @RequestParam(defaultValue = "100", required = false) int size) {
        BaseResponse baseResponseDTO= BaseResponse.builder()
                .Response(nasaService.getAllPruebaDTO(page,size))
                .ErrorResponse(null)
                .build();
        return ResponseEntity.ok(baseResponseDTO);
    }

    /*** Endpoints were comented
    @GetMapping("/info")
    public ResponseEntity<NasaDto> getInfoFromNasaApi(@RequestParam(name="search") String search){
        NasaDto nasainfo=nasaService.getInfoFromNasaApi( search);
        return  ResponseEntity.ok(nasainfo);
    }
     */
    @PostMapping("/info")
    public ResponseEntity<BaseResponse> getAnSaveInfoFromNasaApi(@Valid @RequestParam(name="search", required = true) String search){
        BaseResponse baseResponseDTO= BaseResponse.builder()
                .Response(nasaService.getInfoAnSaveFromNasaApi(search)+ " items saved from Nasa Api")
                .ErrorResponse(null)
                .build();
        return ResponseEntity.ok(baseResponseDTO);
    }


}
