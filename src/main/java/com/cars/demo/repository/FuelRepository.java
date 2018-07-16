package com.cars.demo.repository;

import com.cars.demo.model.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelRepository extends JpaRepository<Fuel,Long> {
}
