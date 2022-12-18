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
@SequenceGenerator(name = "SUB_ALGORITHM_IDX_GENERATOR" , sequenceName = "SUB_ALGORITHM_SEQ" , allocationSize = 1)
public class SubAlgorithm extends DefaultEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SUB_ALGORITHM_IDX_GENERATOR"
    )
    @Column(name = "SUB_ALGORITHM_IDX")
    private Long SubAlgorithmIdx;
    private AlgorithmType algorithmType;
    @Column(name = "SUB_OPT")
    private String subOpt;

    @Builder
    public SubAlgorithm(AlgorithmType algorithmType , String subOpt){
        this.algorithmType = algorithmType;
        this.subOpt = subOpt;
    }
}