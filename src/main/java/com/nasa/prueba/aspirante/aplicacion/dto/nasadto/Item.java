package com.nasa.prueba.aspirante.aplicacion.dto.nasadto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private String href;
    private List<Datum> data;
    private List<Link> links;
}
