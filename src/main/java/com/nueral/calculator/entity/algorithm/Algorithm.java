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
    @ManyToOne
    @JoinColumn(name = "SET_ALGORITHM_NAME",referencedColumnName = "SET_ALGORITHM_NAME")
    private SetAlgorithm setAlgorithm;

    @ManyToOne
    @JoinColumn(name = "MAIN_OPT" , referencedColumnName = "MAIN_ALGORITHM_IDX")
    private MainAlgorithm mainAlgorithm;

    @ManyToOne
    @JoinColumn(name = "SUB_OPT" , referencedColumnName = "SUB_ALGORITHM_IDX")
    private SubAlgorithm subAlgorithm;

    @ManyToOne
    @JoinColumn(name = "SUB_OPT2" , referencedColumnName = "SUB_ALGORITHM_IDX")
    private SubAlgorithm subAlgorithm2;

    public void setCharacters(Characters characters) {
        this.characters = characters;
    }

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
