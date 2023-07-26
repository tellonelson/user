package com.recycob.tutorial.carservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.recycob.tutorial.carservice.entities.Car;
import com.recycob.tutorial.carservice.repositories.CarRepository;

@Service
public class CarService {
	
	CarRepository carRepository;
	
	public CarService(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	public List<Car> getAll() {
		return carRepository.findAll();
	}
	
	public Car getUserById(int id) {
		return carRepository.findById(id).orElse(null);
	}
	
	public Car save(Car car) {
		Car newCar = carRepository.save(car);
		
		return newCar;
	}
	
	public List<Car> getByUserId(int userId) {
		return carRepository.findByUserId(userId);		
	}
}