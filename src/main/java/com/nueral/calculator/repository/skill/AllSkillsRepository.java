package com.nueral.calculator.repository.skill;

import com.nueral.calculator.entity.skill.AllSkills;
import com.nueral.calculator.entity.skill.id.AllSkillId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllSkillsRepository extends JpaRepository<AllSkills , AllSkillId> {
}
