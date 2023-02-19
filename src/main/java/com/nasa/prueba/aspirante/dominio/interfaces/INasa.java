package com.nasa.prueba.aspirante.dominio.interfaces;

import com.nasa.prueba.aspirante.dominio.dto.nasadto.NasaDto;
import com.nasa.prueba.aspirante.dominio.dto.PruebaDto;
import com.nasa.prueba.aspirante.dominio.entities.PruebaEntity;

import java.util.List;

public interface INasa {
    List<PruebaDto> getAllPruebaDTO();
    Long getInfoAnSaveFromNasaApi(String search);

}
