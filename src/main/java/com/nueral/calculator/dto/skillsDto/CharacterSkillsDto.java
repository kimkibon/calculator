package com.nueral.calculator.dto.skillsDto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CharacterSkillsDto {
    private String CharacterName;
    private String skillType;
    private String skillName;
    private String explain;
    private String effect;
    private List<SkillLevelDto> skillLevelDtoList;
}
