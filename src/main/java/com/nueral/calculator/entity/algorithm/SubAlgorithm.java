package com.nueral.calculator.entity.algorithm;

import com.nueral.calculator.entity.DefaultEntity;
import com.nueral.calculator.types.AlgorithmType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class SubAlgorithm extends DefaultEntity {

    @Id
    @Column(name = "SUB_OPT")
    private String subOpt;
    @Column(name = "ALGORITHM_TYPE")
    private AlgorithmType algorithmType;

    @Builder
    public SubAlgorithm(AlgorithmType algorithmType , String subOpt){
        this.algorithmType = algorithmType;
        this.subOpt = subOpt;
    }
}