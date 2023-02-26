package com.nasa.prueba.aspirante.aplicacion.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@Builder
public class BaseResponse {
    @Builder.Default
    private boolean successful=true;
    @Builder.Default
    private HttpStatus status=HttpStatus.OK;
    @Builder.Default
    private Instant date=Instant.now();
    private Object Response;
    private ErrorBaseResponse ErrorResponse;
    @Builder.Default
    private String message="TRANSACTION OK";
}
