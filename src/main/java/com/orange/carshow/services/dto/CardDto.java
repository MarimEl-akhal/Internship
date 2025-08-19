package com.orange.carshow.services.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class CardDto {

    private String thumbnail;
    private long makeID;
    private long modelID;
    @JsonAlias("make")
    private Details makerDetails;
    private Details model;
    private long year;
    private long price;
    private long carStatus;
}
