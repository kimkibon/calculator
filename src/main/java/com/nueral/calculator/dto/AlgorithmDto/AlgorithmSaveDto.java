package com.nueral.calculator.dto.AlgorithmDto;

import com.nueral.calculator.entity.algorithm.Algorithm;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AlgorithmSaveDto {

    private String CharacterName;
    private String AlgorithmType;
    private String setAlgorithm;
    private String mainAlgorithm;
    private String subAlgorithm;
    private String subAlgorithm2;

    public AlgorithmSaveDto(Algorithm algorithm){
        this.CharacterName = algorithm.getCharacters().getName();
        this.AlgorithmType = algorithm.getAlgorithmType().getType();
        this.setAlgorithm = algorithm.getSetAlgorithm().getSetAlgorithmName();
        this.mainAlgorithm = algorithm.getMainAlgorithm().getMainOpt();
        this.subAlgorithm = algorithm.getSubAlgorithm().getSubOpt();
        this.subAlgorithm2 = algorithm.getSubAlgorithm2().getSubOpt();
    }

    public AlgorithmSaveDto(String name , String type){
        this.CharacterName = name;
        this.AlgorithmType = type;
    }
}
