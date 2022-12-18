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
@SequenceGenerator(name = "ALGORITHM_IDX_GENERATOR" , sequenceName = "ALGORITHM_SEQ" , allocationSize = 1)
public class SetAlgorithm extends DefaultEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ALGORITHM_IDX_GENERATOR"
    )
    @Column(name = "SET_ALGORITHM_IDX")
    private Long setAlgorithmIdx;
    @Enumerated(EnumType.STRING)
    private AlgorithmType algorithmType;
    @Column(name = "SET_ALGORITHM_NAME")
    private String setAlgorithmName;
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
