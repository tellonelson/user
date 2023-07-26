package com.recycob.tutorial.carservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recycob.tutorial.carservice.entities.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {
	
	List<Car> findByUserId(int userId);
}
