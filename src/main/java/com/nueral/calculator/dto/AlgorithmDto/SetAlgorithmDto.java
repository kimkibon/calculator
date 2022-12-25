package com.nueral.calculator.dto.AlgorithmDto;

import com.nueral.calculator.entity.algorithm.SetAlgorithm;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SetAlgorithmDto {
    private String setAlgorithmName;
    private String twoSetOpt;
    private String threeSetOpt;

    public SetAlgorithmDto(SetAlgorithm setAlgorithm){
        this.setAlgorithmName = setAlgorithm.getSetAlgorithmName();
        this.twoSetOpt = setAlgorithm.getTwoSetOpt();
         this.threeSetOpt = setAlgorithm.getThreeSetOpt();
    }
}
