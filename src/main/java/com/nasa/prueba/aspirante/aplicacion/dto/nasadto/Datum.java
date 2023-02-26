package com.nasa.prueba.aspirante.aplicacion.dto.nasadto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Datum {
    private String center;
    private String title;
    private List<String> keywords;
    private String nasa_id;
    private Instant date_created;
    private String media_type;
    private String description;
}
