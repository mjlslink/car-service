package com.example.car;

import com.example.car.model.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepositorry extends JpaRepository<CarEntity, Integer> {}
