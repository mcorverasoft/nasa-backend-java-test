package com.nasa.prueba.aspirante.aplicacion.taskscheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.nasa.prueba.aspirante.dominio.interfaces.INasa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PruebaTask {
    private static final Logger log = LoggerFactory.getLogger(PruebaTask.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Autowired
    private INasa nasaService;
    @Scheduled(fixedRate = 60 * 1000)//each minute
    public void getAnSaveInfoFromNasaApi() {
        //Call the getInfoAnSaveFromNasaApi method of our service
        Long registers=nasaService.getInfoAnSaveFromNasaApi("apollo 2011");
        //Print on Log the execution info
        log.info("Execution at {} - {} items saved from NasaApi", dateFormat.format(new Date()),registers);
    }
}
