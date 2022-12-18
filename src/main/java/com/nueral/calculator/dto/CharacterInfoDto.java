package com.nueral.calculator.dto;

import com.nueral.calculator.entity.Characters;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CharacterInfoDto {
    private String characterName;
    private String dealType;
    private String roleType;
    private String areaType;
    private String companyType;
    private int defaultStar;

    public CharacterInfoDto(Characters characters){
        this.characterName = characters.getName();
        this.dealType = characters.getDealType().getType();
        this.roleType = characters.getRoleType().getType();
        this.areaType = characters.getAreaType().getType();
        this.companyType = characters.getCompanyType().getEnglish();
        this.defaultStar = characters.getDefaultStar();
    }
}
