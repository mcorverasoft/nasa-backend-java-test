package com.nasa.prueba.aspirante.aplicacion.dto;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class ErrorBaseResponse {
    private TypeError type;
    List<String> errors=new ArrayList<>();
}
