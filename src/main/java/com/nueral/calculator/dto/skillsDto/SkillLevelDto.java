package com.nueral.calculator.dto.skillsDto;

import com.nueral.calculator.entity.skill.SkillLevels;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SkillLevelDto {
    private double status1;
    private double status2;
    private double status3;
    private double status4;

    public SkillLevelDto(SkillLevels skillLevels) {
        this.status1 = skillLevels.getStatus();
        this.status2 = skillLevels.getStatus2();
        this.status3 = skillLevels.getStatus3();
        this.status4 = skillLevels.getStatus4();
    }
}
