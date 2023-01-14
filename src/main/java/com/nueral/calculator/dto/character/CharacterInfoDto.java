package com.nueral.calculator.dto.character;

import com.nueral.calculator.entity.Characters;
import com.nueral.calculator.entity.algorithm.Algorithm;
import com.nueral.calculator.entity.images.Skins;
import com.nueral.calculator.entity.skill.AllSkills;
import com.nueral.calculator.dto.AlgorithmDto.CharacterAlgorithmDto;
import com.nueral.calculator.dto.goodsDto.GoodsCharacterDto;
import com.nueral.calculator.dto.goodsDto.GoodsStatusCharacterDto;
import com.nueral.calculator.dto.skillsDto.CharacterSkillsDto;
import lombok.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CharacterInfoDto {
    private String characterName;
    private String dealType;
    private String roleType;
    private String areaType;
    private String companyType;
    private int defaultStar;
    private String profile;
    private List<CharacterSkillsDto> characterSkillsDtoList;
    private List<CharacterAlgorithmDto> characterAlgorithmDtoList;
    private List<GoodsStatusCharacterDto> goodsStatusCharactersDtoList;
    private List<GoodsCharacterDto> goodsCharacterDtoList;
    private List<SkinDto> skinDtoList;

    public CharacterInfoDto(Characters characters){
        this.characterName = characters.getName();
        this.dealType = characters.getDealType().getType();
        this.roleType = characters.getRoleType().getType();
        this.areaType = characters.getAreaType().getType();
        this.companyType = characters.getCompanyType().getEnglish();
        this.defaultStar = characters.getDefaultStar();
        this.profile = characters.getProfile();
        this.characterSkillsDtoList = characters.getAllSkillsList().stream().sorted(Comparator.comparing(AllSkills::getSkillType)).map(CharacterSkillsDto::new).collect(Collectors.toList());
        this.characterAlgorithmDtoList = characters.getAlgorithmsList().stream().sorted(Comparator.comparing(Algorithm::getAlgorithmType)).map(CharacterAlgorithmDto::new).collect(Collectors.toList());
        this.goodsCharacterDtoList = characters.getGoodsCharacterList().stream().sorted((c1 , c2) -> c2.getAllGoods().getGoodsLevel() - c1.getAllGoods().getGoodsLevel()).map(GoodsCharacterDto::new).collect(Collectors.toList());
        this.goodsStatusCharactersDtoList = characters.getGoodsStatusCharactersList().stream().map(GoodsStatusCharacterDto::new).collect(Collectors.toList());
        this.skinDtoList = characters.getSkinsList().stream().sorted(Comparator.comparingInt(Skins::getReleaseDate)).map(SkinDto::new).collect(Collectors.toList());
    }
}
