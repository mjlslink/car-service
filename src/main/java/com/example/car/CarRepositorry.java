package com.example.car;

import com.example.car.model.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepositorry extends JpaRepository<CarEntity, Integer> {
    public CarEntity findByModelName(String modelName);
    public List<CarEntity> findByManufacturer(String manufacturer);
 //   public List<CarEntity> findLessThan(Double model_price);
}
