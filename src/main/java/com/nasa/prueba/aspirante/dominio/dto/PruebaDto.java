package com.nasa.prueba.aspirante.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor @AllArgsConstructor
public class PruebaDto {
    private Long id;
    private String href;
    private String center;
    private String title;
    private String nasa_id;
}
