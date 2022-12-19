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
public class SetAlgorithm extends DefaultEntity {

    @Id
    @Column(name = "SET_ALGORITHM_NAME")
    private String setAlgorithmName;

    @Enumerated(EnumType.STRING)
    @Column(name = "ALGORITHM_TYPE")
    private AlgorithmType algorithmType;

    private String twoSetOpt;
    private String threeSetOpt;

    @Builder
    public SetAlgorithm(AlgorithmType algorithmType , String twoSetOpt,
                        String threeSetOpt , String setAlgorithmName){
        this.algorithmType = algorithmType;
        this.twoSetOpt = twoSetOpt;
        this.threeSetOpt = threeSetOpt;
        this.setAlgorithmName = setAlgorithmName;
    }
}
