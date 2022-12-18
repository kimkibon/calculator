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
@SequenceGenerator(name = "MAIN_ALGORITHM_IDX_GENERATOR" , sequenceName = "MAIN_ALGORITHM_SEQ" , allocationSize = 1)
public class MainAlgorithm extends DefaultEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MAIN_ALGORITHM_IDX_GENERATOR"
    )
    @Column(name = "MAIN_ALGORITHM_IDX")
    private Long MainAlgorithmIdx;
    @Enumerated(EnumType.STRING)
    private AlgorithmType algorithmType;
    @Column(name = "MAIN_OPT")
    private String mainOpt;

    @Builder
    public MainAlgorithm(AlgorithmType algorithmType , String mainOpt){
        this.algorithmType = algorithmType;
        this.mainOpt = mainOpt;
    }
}
