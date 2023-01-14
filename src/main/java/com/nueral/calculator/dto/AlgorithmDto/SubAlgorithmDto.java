package com.nueral.calculator.dto.AlgorithmDto;

import com.nueral.calculator.entity.algorithm.SubAlgorithm;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SubAlgorithmDto {
    private String subOpt;
    private String type;

    public SubAlgorithmDto(SubAlgorithm subAlgorithm){
        this.subOpt = subAlgorithm.getSubOpt();
        this.type = subAlgorithm.getAlgorithmType().getType();
    }
}
