package com.example.car;

import com.example.car.model.Car;
import com.example.car.model.Mapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CarService {

    private final Logger logger = LogManager.getLogger();
    private final CarRepositorry carRepositorry;

    @Autowired
    CarService(CarRepositorry repositorry) {
        carRepositorry = repositorry;
    }

    public List<Car> getAllCars() {
        logger.info("Getting all cars");
        return carRepositorry.findAll().stream()
                .map(Mapper::toDto)
                .collect(Collectors.toList());
    }

    public Car getCarByName(String modelName) {
        logger.info("Getting info for model {} ", modelName);
        return Stream.of(carRepositorry.findByModelName(modelName))
                .map(Mapper::toDto).findFirst().get();
    }

    public List<Car> getManufacturerByName(String manufacturer) {
        logger.info("Getting cars for manufacturer {} ", manufacturer);
        return carRepositorry.findByManufacturer(manufacturer).stream()
                .map(Mapper::toDto)
                .toList();
    }

    public List<Car> getAllLessThan(Double price) {
        logger.info("Getting cars less than  {} ", price);
        return carRepositorry.findAll().stream()
                .filter( car -> car.getModelPrice() <= price)
                .map(Mapper::toDto)
                .toList();
    }

}
