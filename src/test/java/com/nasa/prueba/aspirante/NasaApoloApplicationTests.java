package com.nasa.prueba.aspirante;

import com.nasa.prueba.aspirante.aplicacion.restcontroller.PruebaRestController;
import com.nasa.prueba.aspirante.dominio.services.NasaService;
import com.nasa.prueba.aspirante.infraestructura.repository.PruebaInterfaz;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NasaApoloApplicationTests {

	@Autowired
	private PruebaRestController restController;
	@Autowired
	private NasaService nasaService;
	@Autowired
	private PruebaInterfaz repository;

	@Test
	void contextLoads() {
		Assertions.assertThat(restController).isNotNull();
		Assertions.assertThat(nasaService).isNotNull();
		Assertions.assertThat(repository).isNotNull();
	}

}
