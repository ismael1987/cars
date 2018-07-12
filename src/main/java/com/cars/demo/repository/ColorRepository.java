package com.cars.demo.repository;

import com.cars.demo.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository  extends JpaRepository<Long,Color> {

}
