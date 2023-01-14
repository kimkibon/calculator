package com.nueral.calculator.dto.skillsDto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AllSkillsSaveDto {
    private String characterName;
    private String skillType;
    private String skillName;
    private String explain;
    private String effect;
}
