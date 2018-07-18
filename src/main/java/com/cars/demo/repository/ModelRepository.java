package com.cars.demo.repository;

import com.cars.demo.model.Modell;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Modell,Long> {
}
