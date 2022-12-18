package com.nueral.calculator.repository.skill;

import com.nueral.calculator.entity.skill.SkillLevels;
import com.nueral.calculator.entity.skill.id.SkillLevelId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillLevelRepository extends JpaRepository<SkillLevels , SkillLevelId> {
}
