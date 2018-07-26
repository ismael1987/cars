package com.cars.demo.repository;

import com.cars.demo.model.TypeOfCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOfCarRepository extends JpaRepository<TypeOfCar,Long> {
}
