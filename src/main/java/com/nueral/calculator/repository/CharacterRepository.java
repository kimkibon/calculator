package com.nueral.calculator.repository;

import com.nueral.calculator.entity.Characters;
import com.nueral.calculator.entity.algorithm.Algorithm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CharacterRepository extends JpaRepository<Characters, String> {
    Optional<Characters> findByName(String name);
    List<Characters> findAll();
    Optional<Algorithm> findAlgorithmByName(String name);
}
