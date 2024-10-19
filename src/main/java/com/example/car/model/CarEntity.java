package com.example.car.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="cars")
@Getter @Setter
public class CarEntity {
    @Id
    private Integer id;
    private String modelName;
    private Double modelPrice;
    private String manufacturer;
    private String vin;

}
