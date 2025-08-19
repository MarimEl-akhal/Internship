package com.orange.carshow.services;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orange.carshow.services.dto.CardDto;

import lombok.SneakyThrows;

@ExtendWith(SpringExtension.class)
class CarServiceTest {

    @Mock
    ObjectMapper mapper;
    @InjectMocks
    CarService carService;

    @Test
    @SneakyThrows
    void when_GetCars_ThenSuccess() {
        //when
        when(mapper.readValue(anyString(), eq(CardDto[].class))).thenReturn(new CardDto[]{});
        var response = carService.getCars();
        //then
        assertEquals(response.size(), 0);
    }
}
