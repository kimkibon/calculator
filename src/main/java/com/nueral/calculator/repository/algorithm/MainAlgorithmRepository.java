package com.nueral.calculator.repository.algorithm;

import com.nueral.calculator.entity.algorithm.MainAlgorithm;
import com.nueral.calculator.types.AlgorithmType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MainAlgorithmRepository extends JpaRepository<MainAlgorithm , String> {
    Optional<MainAlgorithm> findAllByAlgorithmTypeAndMainOpt(AlgorithmType algorithmType , String mainOpt);
}
