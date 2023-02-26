package com.nasa.prueba.aspirante.aplicacion.dto.nasadto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private String href;
    private String rel;
    private String render;
}