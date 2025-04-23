package com.example.petShop;

import com.example.petShop.controller.AnimalController;
import com.example.petShop.Service.AnimalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PetShopApplicationTests {

	@Autowired
	private AnimalController animalController;

	@Autowired
	private AnimalService animalService;

	@Test
	void contextLoads() {
		// Verifica se o contexto do Spring foi carregado corretamente
		assertThat(animalController).isNotNull();
		assertThat(animalService).isNotNull();
	}
}