package com.nueral.calculator.dto;

import com.nueral.calculator.dto.AlgorithmDto.CharacterAlgorithmDto;
import com.nueral.calculator.dto.goodsDto.GoodsCharacterDto;
import com.nueral.calculator.dto.goodsDto.GoodsStatusCharacterDto;
import com.nueral.calculator.dto.skillsDto.CharacterSkillsDto;
import com.nueral.calculator.entity.Characters;
import lombok.*;

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
    private List<CharacterSkillsDto> characterSkillsDtoList;
    private List<CharacterAlgorithmDto> characterAlgorithmDtoList;
    private List<GoodsStatusCharacterDto> goodsStatusCharactersDtoList;
    private List<GoodsCharacterDto> goodsCharacterDtoList;

    public CharacterInfoDto(Characters characters){
        this.characterName = characters.getName();
        this.dealType = characters.getDealType().getType();
        this.roleType = characters.getRoleType().getType();
        this.areaType = characters.getAreaType().getType();
        this.companyType = characters.getCompanyType().getEnglish();
        this.defaultStar = characters.getDefaultStar();
        this.characterSkillsDtoList = characters.getAllSkillsList().stream().map(CharacterSkillsDto::new).collect(Collectors.toList());
        this.characterAlgorithmDtoList = characters.getAlgorithmsList().stream().map(CharacterAlgorithmDto::new).collect(Collectors.toList());
        this.goodsCharacterDtoList = characters.getGoodsCharacterList().stream().map(GoodsCharacterDto::new).collect(Collectors.toList());
        this.goodsStatusCharactersDtoList = characters.getGoodsStatusCharactersList().stream().map(GoodsStatusCharacterDto::new).collect(Collectors.toList());
    }
}
