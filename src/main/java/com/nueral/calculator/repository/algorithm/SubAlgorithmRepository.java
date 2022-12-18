package com.nueral.calculator.repository.algorithm;

import com.nueral.calculator.entity.algorithm.SubAlgorithm;
import com.nueral.calculator.types.AlgorithmType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubAlgorithmRepository extends JpaRepository<SubAlgorithm , Long> {

    Optional<SubAlgorithm> findAllByAlgorithmTypeAndSubOpt(AlgorithmType algorithmType , String SubOpt);

}
