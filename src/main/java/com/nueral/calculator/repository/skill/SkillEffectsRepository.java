package com.nueral.calculator.repository.skill;

import com.nueral.calculator.entity.skill.SkillEffects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillEffectsRepository extends JpaRepository<SkillEffects , String> {
    long deleteByEffectIndex(int effectIndex);
}
