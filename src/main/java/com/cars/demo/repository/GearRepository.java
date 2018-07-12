package com.cars.demo.repository;

import com.cars.demo.model.Gear;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GearRepository extends JpaRepository <Gear,Long> {
}
