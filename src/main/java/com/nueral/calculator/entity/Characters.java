package com.nueral.calculator.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.nueral.calculator.entity.algorithm.Algorithm;
import com.nueral.calculator.entity.friendship.GoodsCharacter;
import com.nueral.calculator.entity.friendship.GoodsStatusCharacter;
import com.nueral.calculator.entity.skill.AllSkills;
import com.nueral.calculator.types.AreaType;
import com.nueral.calculator.types.CompanyType;
import com.nueral.calculator.types.DealType;
import com.nueral.calculator.types.RoleType;
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
public class Characters extends DefaultEntity{

    //케릭터 이름
    @Id
    @Column(name = "CHARACTER_NAME")
    private String name;
    //딜링 타입
    @Enumerated(EnumType.STRING)
    private DealType dealType;
    //직업
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    //범위
    @Enumerated(EnumType.STRING)
    private AreaType areaType;
    //기초 성급

    @Enumerated(EnumType.STRING)
    private CompanyType companyType;

    private int defaultStar;

    @OneToMany(mappedBy = "characters" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<AllSkills> allSkillsList;

    @OneToMany(mappedBy = "characters" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Algorithm> algorithmsList;

    @OneToMany(mappedBy = "characters" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<GoodsStatusCharacter> goodsStatusCharactersList;

    @OneToMany(mappedBy = "characters" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<GoodsCharacter> goodsCharacterList;

    @Builder
    public Characters(
            String name, DealType dealType , RoleType roleType,
            AreaType areaType , int defaultStar , CompanyType companyType ){
        this.name = name;
        this.dealType = dealType;
        this.roleType = roleType;
        this.areaType = areaType;
        this.defaultStar = defaultStar;
        this.companyType = companyType;
    }

}
