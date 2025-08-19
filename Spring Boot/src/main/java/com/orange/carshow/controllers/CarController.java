package com.orange.carshow.controllers;

import java.util.List;

//import com.orange.carshow.services.dto.CarRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.orange.carshow.services.CarService;
import com.orange.carshow.services.dto.CarDto;


@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private  CarService carService;

//    public CarController(CarService carService) {
//        this.carService = carService;
//    }


    @GetMapping
    public List<CarDto> getCars() {
        return carService.getCars();
    }


    @GetMapping("/expensiveCar")
    public ResponseEntity<CarDto> getMostExpensiveCar() {
        CarDto CarDto = carService.expensiveCar();
        if (CarDto != null) {
            return ResponseEntity.ok(CarDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable Long id) {
        return carService.getCars().stream()
                .filter(car -> id== car.getModel().getId()) // safer than ==
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }




    @PostMapping
    public ResponseEntity<CarDto> addNewCar(@RequestBody CarDto carDto) {
        CarDto addedCar = carService.addCar(carDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedCar);
    }

//    @PostMapping
//    public ResponseEntity<CarDto> addNewCar(@RequestBody CarDto carDto) {
//        CarDto addedCar = carService.addCar(carDto);
//        if (addedCar != null) {
//            return ResponseEntity.ok(addedCar);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CarDto> deleteCar(@PathVariable Long id) {
        CarDto carToDelete = carService.getCarById(id);
        if (carToDelete != null) {
            carService.deleteCarById(id);
            return ResponseEntity.ok(carToDelete);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/filterByModel")
    public ResponseEntity<List<CarDto>> filterCarsByModel(@RequestParam String model) {
        List<CarDto> carDtoList = carService.filterCarsByModel(model);
        return ResponseEntity.ok(carDtoList);
    }



    @GetMapping("/filterByMake")
    public ResponseEntity<List<CarDto>> filterCarsByMake(@RequestParam String make) {
        List<CarDto> filteredCars = carService.filterCarsByMake(make);
        return ResponseEntity.ok(filteredCars);
    }







}
