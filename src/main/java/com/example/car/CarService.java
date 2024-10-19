package com.example.car;

import com.example.car.model.Car;
import com.example.car.model.Mapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
}
