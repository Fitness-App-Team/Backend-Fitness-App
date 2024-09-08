package com.sohail.fitnessapp.persistence.repository;

import com.sohail.fitnessapp.persistence.entity.Fitness;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FitnessRepository extends JpaRepository<Fitness, Long> {
    List<Fitness> findByType(String type);

}
