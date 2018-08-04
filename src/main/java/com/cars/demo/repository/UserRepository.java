package com.cars.demo.repository;

import com.cars.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findOneByLogin(String loing);
    Optional<User> findOneByEmail(String email);
}
