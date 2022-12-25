package com.nueral.calculator.dto;

import com.nueral.calculator.entity.Characters;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AllCharactersDto {
    String characterName;
    String roleType;
    String dealType;
    int defaultStar;

    public AllCharactersDto(Characters characters){
        this.characterName = characters.getName();
        this.dealType = characters.getDealType().getType();
        this.roleType = characters.getRoleType().getType();
        this.defaultStar = characters.getDefaultStar();
    }

}
