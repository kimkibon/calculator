package com.nueral.calculator.dto.AlgorithmDto;

import com.nueral.calculator.entity.algorithm.MainAlgorithm;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MainAlgorithmDto {
    private String mainOpt;
    private String type;

    public MainAlgorithmDto(MainAlgorithm mainAlgorithm){
        this.mainOpt = mainAlgorithm.getMainOpt();
        this.type = mainAlgorithm.getAlgorithmType().getType();
    }
}
