package com.nueral.calculator.entity.algorithm;

import com.nueral.calculator.entity.Characters;
import com.nueral.calculator.entity.DefaultEntity;
import com.nueral.calculator.entity.algorithm.id.AlgorithmId;
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
@IdClass(AlgorithmId.class)
public class Algorithm extends DefaultEntity {
    @Id
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CHARACTER_NAME", nullable = false , referencedColumnName ="CHARACTER_NAME")
    @ToString.Exclude
    private Characters characters;
    @Id
    @Enumerated(EnumType.STRING)
    private AlgorithmType algorithmType;
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "SET_ALGORITHM_NAME",referencedColumnName = "SET_ALGORITHM_NAME")
    @ToString.Exclude
    private SetAlgorithm setAlgorithm;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "MAIN_OPT" , referencedColumnName = "MAIN_OPT")
    @ToString.Exclude
    private MainAlgorithm mainAlgorithm;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "SUB_OPT" , referencedColumnName = "SUB_OPT")
    @ToString.Exclude
    private SubAlgorithm subAlgorithm;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "SUB_OPT2" , referencedColumnName = "SUB_OPT")
    @ToString.Exclude
    private SubAlgorithm subAlgorithm2;

    @Builder
    public Algorithm(
            Characters characters, AlgorithmType algorithmType,
            SetAlgorithm setAlgorithm , MainAlgorithm mainAlgorithm,
            SubAlgorithm subAlgorithm , SubAlgorithm subAlgorithm2
    ){
        this.characters = characters;
        this.algorithmType = algorithmType;
        this.setAlgorithm = setAlgorithm;
        this.mainAlgorithm = mainAlgorithm;
        this.subAlgorithm = subAlgorithm;
        this.subAlgorithm2 = subAlgorithm2;
    }
}
