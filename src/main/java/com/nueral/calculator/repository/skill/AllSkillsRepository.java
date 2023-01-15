package com.nueral.calculator.repository.skill;

import com.nueral.calculator.entity.skill.AllSkills;
import com.nueral.calculator.entity.skill.id.AllSkillId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AllSkillsRepository extends JpaRepository<AllSkills , AllSkillId> {
    @Query(value = "select * from All_Skills s where s.character_name = :name" ,nativeQuery = true)
    List<AllSkills> findByCharacterName(@Param("name") String name);
}
