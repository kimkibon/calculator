package com.nueral.calculator.repository.algorithm;

import com.nueral.calculator.entity.algorithm.Algorithm;
import com.nueral.calculator.entity.algorithm.id.AlgorithmId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlgorithmRepository extends JpaRepository<Algorithm , AlgorithmId> {

}
