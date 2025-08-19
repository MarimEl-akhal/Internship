package com.orange.carshow.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orange.carshow.services.dto.CarRequest;
import com.orange.carshow.services.dto.CardDto;

import jakarta.annotation.PostConstruct;

@Service
public class CarServiceImpl implements CarService {

    private String cars ="""
            [
    {
        "thumbnail": "Engines/092686e316f248b9b49a64dba8ac89b1_a9621717-f7d4-4af2-9a45-df4be20cf428.jpeg",
        "makeId": 3,
        "modelId": 457,
        "make": {
            "id": 3,
            "nameAr": "مرسيدس",
            "nameEn": "Mercedes"
        },
        "model": {
            "id": 457,
            "nameAr": "B 200",
            "nameEn": "B 200"
        },
        "year": 2023,
        "price": 1675000,
        "carStatus": 1
    },
    {
        "thumbnail": "Engines/6155a812c77e13abc03149c3_119e422e-e7cb-4e87-bbea-8788de70594a.jpeg",
        "makeId": 3,
        "modelId": 7,
        "make": {
            "id": 3,
            "nameAr": "مرسيدس",
            "nameEn": "Mercedes"
        },
        "model": {
            "id": 7,
            "nameAr": "C180",
            "nameEn": "C180"
        },
        "year": 2023,
        "price": 2280000,
        "carStatus": 1
    },
    {
        "thumbnail": "Engines/6155b0481479a75b1631670e_b4ec6c7c-2357-48fc-9438-4803284cf2a2.jpeg",
        "makeId": 3,
        "modelId": 5,
        "make": {
            "id": 3,
            "nameAr": "مرسيدس",
            "nameEn": "Mercedes"
        },
        "model": {
            "id": 5,
            "nameAr": "C200",
            "nameEn": "C200"
        },
        "year": 2023,
        "price": 2705000,
        "carStatus": 1
    },
    {
        "thumbnail": "Engines/71ffe337f25e476e925d56c1800f628b_8269ef44-5b99-4953-97fe-7ff6ed857b6c.jpeg",
        "makeId": 3,
        "modelId": 509,
        "make": {
            "id": 3,
            "nameAr": "مرسيدس",
            "nameEn": "Mercedes"
        },
        "model": {
            "id": 509,
            "nameAr": "CLA 200",
            "nameEn": "CLA 200"
        },
        "year": 2023,
        "price": 1943000,
        "carStatus": 1
    },
    {
        "thumbnail": "Engines/60199e1b110a623ace63578f_2649b04d-6f0a-457a-9beb-aa690e59ba5f.jpeg",
        "makeId": 3,
        "modelId": 72,
        "make": {
            "id": 3,
            "nameAr": "مرسيدس",
            "nameEn": "Mercedes"
        },
        "model": {
            "id": 72,
            "nameAr": "E200",
            "nameEn": "E200"
        },
        "year": 2023,
        "price": 2950000,
        "carStatus": 1
    },
    {
        "thumbnail": "Engines/6166c4f7462e7d72432ff671_f4b2860e-ac83-41d0-a3de-28e86de7cb10.jpeg",
        "makeId": 3,
        "modelId": 353,
        "make": {
            "id": 3,
            "nameAr": "مرسيدس",
            "nameEn": "Mercedes"
        },
        "model": {
            "id": 353,
            "nameAr": "E300",
            "nameEn": "E300"
        },
        "year": 2023,
        "price": 3950000,
        "carStatus": 1
    },
    {
        "thumbnail": "Engines/6177f3e28a661cbb7cdb587c_4fa6d45b-5095-4b3e-bad3-d8847372f303.jpeg",
        "makeId": 3,
        "modelId": 853,
        "make": {
            "id": 3,
            "nameAr": "مرسيدس",
            "nameEn": "Mercedes"
        },
        "model": {
            "id": 853,
            "nameAr": "E53",
            "nameEn": "E53"
        },
        "year": 2022,
        "price": 5100000,
        "carStatus": 1
    },
    {
        "thumbnail": "Engines/6e3e7c5e9a4a_ef4bae70-dfd2-476f-906d-8c3c511aee7f.jpeg",
        "makeId": 3,
        "modelId": 1385,
        "make": {
            "id": 3,
            "nameAr": "مرسيدس",
            "nameEn": "Mercedes"
        },
        "model": {
            "id": 1385,
            "nameAr": "EQA 350 ",
            "nameEn": "EQA 350 "
        },
        "year": 2024,
        "price": 2500000,
        "carStatus": 1
    },
    {
        "thumbnail": "Engines/61a4cc99af7d9a62ad2456ab_6fe53d7d-99dc-48f8-a7c9-4798909d8ca7.jpeg",
        "makeId": 3,
        "modelId": 636,
        "make": {
            "id": 3,
            "nameAr": "مرسيدس",
            "nameEn": "Mercedes"
        },
        "model": {
            "id": 636,
            "nameAr": "G 500",
            "nameEn": "G 500"
        },
        "year": 2022,
        "price": 5500000,
        "carStatus": 1
    },
    {
        "thumbnail": "Engines/61a4daecaf7d9a62ad2456e9_7bb301b4-03ca-4f1e-a2e1-a82792bff729.jpeg",
        "makeId": 3,
        "modelId": 825,
        "make": {
            "id": 3,
            "nameAr": "مرسيدس",
            "nameEn": "Mercedes"
        },
        "model": {
            "id": 825,
            "nameAr": "G 63",
            "nameEn": "G 63"
        },
        "year": 2022,
        "price": 7750000,
        "carStatus": 1
    },
    {
        "thumbnail": "Engines/615d853f79650690cbb72bc1_52d84825-be4d-45e6-88db-7d69827b0978.jpeg",
        "makeId": 3,
        "modelId": 538,
        "make": {
            "id": 3,
            "nameAr": "مرسيدس",
            "nameEn": "Mercedes"
        },
        "model": {
            "id": 538,
            "nameAr": "GLA 200",
            "nameEn": "GLA 200"
        },
        "year": 2023,
        "price": 2025000,
        "carStatus": 1
    },
    {
        "thumbnail": "Engines/60199e1b110a623ace6356f8_12e90ba4-42bf-4059-9d27-7f9566f8bd29.jpeg",
        "makeId": 3,
        "modelId": 1208,
        "make": {
            "id": 3,
            "nameAr": "مرسيدس",
            "nameEn": "Mercedes"
        },
        "model": {
            "id": 1208,
            "nameAr": "GLC 300 COUPE",
            "nameEn": "GLC 300 COUPE"
        },
        "year": 2022,
        "price": 3055000,
        "carStatus": 1
    }
]
            """;

    private List<CardDto> carLits = new ArrayList<>();
    private final ObjectMapper mapper;

    public CarServiceImpl(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @PostConstruct
    public void initList() throws Throwable, JsonProcessingException {
        carLits.addAll(Arrays.asList(mapper.readValue(cars, CardDto[].class)));
    }

    public List<CardDto> getCars() {
        return carLits;
    }


}
