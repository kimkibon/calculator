package com.nueral.calculator.dto.AlgorithmDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlgorithmSaveDtoList {
    List<AlgorithmSaveDto> algorithmSaveDto;

    public void addDto(AlgorithmSaveDto algorithmSaveDto){
        this.algorithmSaveDto.add(algorithmSaveDto);
    }
}
