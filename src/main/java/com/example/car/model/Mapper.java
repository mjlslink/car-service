package com.example.car.model;

public class Mapper {

    public static CarEntity toEntity(Car car) {
        CarEntity entity = new CarEntity();
        entity.setModelName(car.getModelName());
        entity.setManufacturer(car.getManufacturer());
        entity.setVin(car.getVin());
        return entity;
    }

    public static Car toDto(CarEntity entity) {
        Car car = new Car();
        car.setModelName(entity.getModelName());
        car.setManufacturer(entity.getManufacturer());
        car.setVin(entity.getVin());
        return car;
    }
}
