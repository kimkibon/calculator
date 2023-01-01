package com.nueral.calculator.dto.save;

import com.nueral.calculator.entity.Characters;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CharacterSaveDto {
    private String characterName;
    private String dealType;
    private String roleType;
    private String areaType;
    private String companyType;
    private int defaultStar;
    private String profile;

    public CharacterSaveDto(Characters characters){
        this.characterName = characters.getName();
        this.areaType = characters.getAreaType().name();
        this.companyType = characters.getCompanyType().name();
        this.profile = characters.getProfile();
        this.dealType = characters.getDealType().name();
        this.defaultStar = characters.getDefaultStar();
        this.roleType = characters.getRoleType().name();
    }
}
