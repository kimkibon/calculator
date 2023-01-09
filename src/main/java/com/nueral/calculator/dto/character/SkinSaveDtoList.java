package com.nueral.calculator.dto.character;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SkinSaveDtoList {
    private List<SkinSaveDto> skinSaveDto;

    public void addDto(SkinSaveDto skinSaveDto){
        this.skinSaveDto.add(skinSaveDto);
    }
}
