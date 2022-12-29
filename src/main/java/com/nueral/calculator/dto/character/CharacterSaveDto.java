package com.nueral.calculator.dto.character;

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
}
