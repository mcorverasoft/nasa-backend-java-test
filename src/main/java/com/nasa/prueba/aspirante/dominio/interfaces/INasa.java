package com.nasa.prueba.aspirante.dominio.interfaces;

import com.nasa.prueba.aspirante.aplicacion.dto.PruebaDto;

import java.util.List;

public interface INasa {
    List<PruebaDto> getAllPruebaDTO(int page, int size);
    Long getInfoAnSaveFromNasaApi(String search);

}
