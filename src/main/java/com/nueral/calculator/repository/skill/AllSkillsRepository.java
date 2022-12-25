package com.nueral.calculator.repository.skill;

import com.nueral.calculator.entity.Characters;
import com.nueral.calculator.entity.skill.AllSkills;
import com.nueral.calculator.entity.skill.id.AllSkillId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AllSkillsRepository extends JpaRepository<AllSkills , AllSkillId> {
    List<Characters> findAllByCharacters(Characters characters);
}
