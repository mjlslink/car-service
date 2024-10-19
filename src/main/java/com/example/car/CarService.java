package com.example.car;

import com.example.car.model.Car;
import com.example.car.model.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
gi
    private final CarRepositorry carRepositorry;

    @Autowired
    CarService(CarRepositorry repositorry) {
        carRepositorry = repositorry;
    }

    public List<Car> getAllCars() {
        return carRepositorry.findAll().stream()
                .map(Mapper::toDto)
                .collect(Collectors.toList());
    }
}
