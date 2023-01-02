package com.nueral.calculator.repository.algorithm;

import com.nueral.calculator.entity.algorithm.SetAlgorithm;
import com.nueral.calculator.types.AlgorithmType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SetAlgorithmRepository extends JpaRepository<SetAlgorithm , String> {
    Optional<SetAlgorithm> findAllByAlgorithmTypeAndSetAlgorithmName(AlgorithmType algorithmType , String name);
}
