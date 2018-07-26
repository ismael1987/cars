package com.cars.demo.repository;

import com.cars.demo.model.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface FuelRepository extends JpaRepository<Fuel,Long> {
}
