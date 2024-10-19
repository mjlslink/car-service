package com.example.car;

import com.example.car.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    private final CarService carService;

    @Autowired
    CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Car>> getAllCars() {
        return new ResponseEntity<List<Car>>(carService.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("/car-model/{model_name}")
    public ResponseEntity<Car> getCarsByModelName(@PathVariable(name = "model_name") String modelName) {
        return new ResponseEntity<Car>(carService.getCarByName(modelName), HttpStatus.OK);
    }

    @GetMapping("/car-manufacturer/{manufacturer}")
    public ResponseEntity<List<Car>> getCarsByManufactuer(@PathVariable(name = "manufacturer") String modelName) {
        return new ResponseEntity<List<Car>>(carService.getManufacturerByName(modelName), HttpStatus.OK);
    }

    @GetMapping("/search-prices-less-than/{model-price}")
    public ResponseEntity<List<Car>> getCarsByLeesThan(@PathVariable(name = "model-price") String price) {
        return new ResponseEntity<List<Car>>(carService.getAllLessThan(Double.valueOf(price)), HttpStatus.OK);
    }

}
