package com.nasa.prueba.aspirante.dominio.services;

import com.nasa.prueba.aspirante.dominio.interfaces.INasa;
import com.nasa.prueba.aspirante.aplicacion.dto.nasadto.NasaDto;
import com.nasa.prueba.aspirante.aplicacion.dto.PruebaDto;
import com.nasa.prueba.aspirante.infraestructura.entities.PruebaEntity;
import com.nasa.prueba.aspirante.infraestructura.clientrest.PruebaClienteRest;
import com.nasa.prueba.aspirante.infraestructura.repository.PruebaInterfaz;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
    public List<PruebaDto> getAllPruebaDTO(int page, int size) {
        Pageable paging = PageRequest.of(page, size, Sort.by("id"));
        Page<PruebaEntity> pruebaEntityPage =pruebaInterfazRepository.findAll(paging);
        return pruebaEntityPage.getContent()
                .stream()
                .map(pruebaEntity -> modelMapper.map(pruebaEntity,PruebaDto.class)).collect(Collectors.toList());
    }

    @Override
    public Long getInfoAnSaveFromNasaApi(String search) {

        //Atomic variable by parallel use
        AtomicInteger counter= new AtomicInteger(0);
        try{
            //Get info from NASA api
            NasaDto nasaDto=pruebaNasaApiClient.getInfo(search);
            nasaDto.getCollection().getItems().stream().parallel().forEach(item ->{
                                                                //creating a new Entity PruebaEntity
                                                                PruebaEntity pruebaEntity=new PruebaEntity();
                                                                pruebaEntity.setHref(item.getHref());
                                                                pruebaEntity.setCenter(item.getData().stream().findFirst().get().getCenter());
                                                                pruebaEntity.setTitle(item.getData().stream().findFirst().get().getTitle());
                                                                pruebaEntity.setNasa_id(item.getData().stream().findFirst().get().getNasa_id());
                                                                //save the entity
                                                                if(pruebaInterfazRepository.save(pruebaEntity).getId()>0)
                                                                    counter.addAndGet(1);
                                                                } );
        }catch (Exception exp){
            //catching the exception
            log.error(exp.getMessage());
        }
        //return number of saved items
        return Long.valueOf( counter.get());
    }

}
