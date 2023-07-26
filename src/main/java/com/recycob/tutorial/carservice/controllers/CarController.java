package com.recycob.tutorial.carservice.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recycob.tutorial.carservice.entities.Car;
import com.recycob.tutorial.carservice.services.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {
	
	CarService carService;

	public CarController(CarService carService) {
		this.carService = carService;
	}

	@GetMapping
	public ResponseEntity<List<Car>> getAll() {
		
		List<Car> cars = carService.getAll();
		if(cars.isEmpty())
			return ResponseEntity.noContent().build();
		
		return ResponseEntity.ok(cars);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Car> getById(@PathVariable("id") int id) {
		
		Car car = carService.getUserById(id);
		if(car == null)
			return ResponseEntity.noContent().build();
		
		return ResponseEntity.ok(car);
		
	}

	@PostMapping()
	public ResponseEntity<Car> save(@RequestBody Car car) {
		
		Car newCar = carService.save(car);
		
		return ResponseEntity.ok(newCar);
		
	}

	@GetMapping("/byuser/{userId}")
	public ResponseEntity<List<Car>> getByUserId(@PathVariable("userId") int userId) {
		
		List<Car> cars = carService.getByUserId(userId);
		if(cars.isEmpty())
			return ResponseEntity.noContent().build();
		
		return ResponseEntity.ok(cars);
		
	}

}