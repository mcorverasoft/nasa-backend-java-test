package com.nasa.prueba.aspirante.dominio.dto.nasadto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Collection {
    private String version;
    private String href;
    private List<Item> items;
    private Metadata metadata;
}
