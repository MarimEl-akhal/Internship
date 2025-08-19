package com.orange.carshow.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

import com.orange.carshow.services.dto.CardDto;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CarsControllerIntegrationTest {

	@Autowired
	TestRestTemplate restTemplate;

	@Test
	void whenGetCarsThenRturnNotEmptyList() {
		//when
		var response = restTemplate.getForEntity("/cars", CardDto[].class);

		//then
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotEquals(response.getBody().length,  0);
	}

}
