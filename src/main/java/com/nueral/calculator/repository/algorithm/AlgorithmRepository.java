package com.nueral.calculator.repository.algorithm;

import com.nueral.calculator.entity.algorithm.Algorithm;
import com.nueral.calculator.entity.algorithm.id.AlgorithmId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlgorithmRepository extends JpaRepository<Algorithm , AlgorithmId> {

    @Query(value = "select * from Algorithm s where s.character_name = :name" ,nativeQuery = true)
    List<Algorithm> findByCharacterName(@Param("name")String name);
}
