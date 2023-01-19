package com.nueral.calculator.repository.skill;

import com.nueral.calculator.entity.skill.AllSkills;
import com.nueral.calculator.entity.skill.SkillEffectsMap;
import com.nueral.calculator.entity.skill.id.SkillEffectsMapId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillEffectsMapRepository extends JpaRepository<SkillEffectsMap, SkillEffectsMapId> {
    long deleteByAllSkills(AllSkills allSkills);

}
