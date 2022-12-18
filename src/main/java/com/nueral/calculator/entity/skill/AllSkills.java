package com.nueral.calculator.entity.skill;

import com.nueral.calculator.entity.Characters;
import com.nueral.calculator.entity.DefaultEntity;
import com.nueral.calculator.entity.skill.id.AllSkillId;
import com.nueral.calculator.types.SkillType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor
@IdClass(AllSkillId.class)
public class AllSkills extends DefaultEntity {
    @Id
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CHARACTER_NAME" , referencedColumnName ="CHARACTER_NAME")
    private Characters characters;

    @Enumerated(EnumType.STRING)
    private SkillType skillType;
    @Id
    @Column(name = "skill_name" , nullable = false)
    private String skillName;
    private String explain;
    private String effect;

    @OneToMany(mappedBy = "allSkills")
    @ToString.Exclude
    private List<SkillLevels> skillLevelsList;


    @Builder
    public AllSkills(
            Characters characters, SkillType skillType ,
            String skillName , String explain , String effect
    ){
        this.characters = characters;
        this.skillName = skillName;
        this.skillType = skillType;
        this.explain = explain;
        this.effect = effect;
    }

}
