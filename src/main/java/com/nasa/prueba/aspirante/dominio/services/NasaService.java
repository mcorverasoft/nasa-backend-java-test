package com.nasa.prueba.aspirante.dominio.services;

import com.nasa.prueba.aspirante.dominio.interfaces.INasa;
import com.nasa.prueba.aspirante.dominio.dto.nasadto.NasaDto;
import com.nasa.prueba.aspirante.dominio.dto.PruebaDto;
import com.nasa.prueba.aspirante.dominio.entities.PruebaEntity;
import com.nasa.prueba.aspirante.infraestructura.clientrest.PruebaClienteRest;
import com.nasa.prueba.aspirante.infraestructura.repository.PruebaInterfaz;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class NasaService implements INasa {
    private static final Logger log = LoggerFactory.getLogger(NasaService.class);
    @Autowired
    private PruebaInterfaz pruebaInterfazRepository;
    @Autowired
    private PruebaClienteRest pruebaNasaApiClient;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<PruebaDto> getAllPruebaDTO() {
        return pruebaInterfazRepository.findAll()
                .stream()
                .map(pruebaEntity -> modelMapper.map(pruebaEntity,PruebaDto.class)).collect(Collectors.toList());
    }

    @Override
    public Long getInfoAnSaveFromNasaApi(String search) {
        NasaDto nasaDto=pruebaNasaApiClient.getInfo(search);
        AtomicInteger counter= new AtomicInteger(0);
        try{
        nasaDto.getCollection().getItems().stream().parallel().forEach(item ->{
                                                                PruebaEntity pruebaEntity=new PruebaEntity();
                                                                pruebaEntity.setHref(item.getHref());
                                                                pruebaEntity.setCenter(item.getData().stream().findFirst().get().getCenter());
                                                                pruebaEntity.setTitle(item.getData().stream().findFirst().get().getTitle());
                                                                pruebaEntity.setNasa_id(item.getData().stream().findFirst().get().getNasa_id());
                                                                if(pruebaInterfazRepository.save(pruebaEntity).getId()>0)
                                                                    counter.addAndGet(1);
        } );
        }catch (Exception exp){
            log.error(exp.getMessage());
        }
        return Long.valueOf( counter.get());
    }

}