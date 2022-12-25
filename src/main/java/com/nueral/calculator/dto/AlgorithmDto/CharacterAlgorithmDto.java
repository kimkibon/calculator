package com.nueral.calculator.dto.AlgorithmDto;

import com.nueral.calculator.entity.algorithm.Algorithm;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CharacterAlgorithmDto {
    private String algorithmType;
    private SetAlgorithmDto setAlgorithmDto;
    private String mainOpt;
    private String subOpt1;
    private String subOpt2;

    public CharacterAlgorithmDto(Algorithm algorithm){
        this.algorithmType = algorithm.getAlgorithmType().getType();
        this.setAlgorithmDto = new SetAlgorithmDto(algorithm.getSetAlgorithm());
        this.mainOpt = algorithm.getMainAlgorithm().getMainOpt();
        this.subOpt1 = algorithm.getSubAlgorithm().getSubOpt();
        this.subOpt2 = algorithm.getSubAlgorithm2().getSubOpt();
    }
}
