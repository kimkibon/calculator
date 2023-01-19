package com.nueral.calculator.service.skill;

import com.nueral.calculator.dto.skillsDto.CharacterSkillsDto;
import com.nueral.calculator.dto.skillsDto.CharacterSkillsDtoList;
import com.nueral.calculator.dto.skillsDto.SkillEffectDto;
import com.nueral.calculator.dto.skillsDto.SkillEffectDtoList;
import com.nueral.calculator.entity.skill.AllSkills;
import com.nueral.calculator.repository.CharacterRepository;
import com.nueral.calculator.repository.skill.AllSkillsRepository;
import com.nueral.calculator.repository.skill.SkillEffectsRepository;
import com.nueral.calculator.types.SkillType;
import com.nueral.calculator.utils.FindTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillSaveService {
    @Autowired
    private AllSkillsRepository allSkillsRepository;
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private FindTypes findTypes;
    @Autowired
    private SkillEffectsRepository skillEffectsRepository;

    /**
    public void saveAllSkills(
            String characterName, SkillType ,
            String skillName , String explain , String effect
    ){
        Characters characters = characterRepository.findByName(characterName).orElseThrow();

        AllSkills allSkills = AllSkills.builder()
                .skillType(skillType)
                .characters(characters)
                .effect(effect)
                .explain(explain)
                .skillName(skillName)
                .build();

        allSkillsRepository.save(allSkills);

    }

    public void saveAllSkillsByDto(AllSkillsSaveDto allSkillsSaveDto){
        Characters characters = characterRepository.findByName(allSkillsSaveDto.getCharacterName()).orElseThrow();

        AllSkills allSkills = AllSkills.builder()
                .characters(characters)
                .skillType(SkillType.valueOf(allSkillsSaveDto.getSkillName()))
                .skillName(allSkillsSaveDto.getSkillName())
                .explain(allSkillsSaveDto.getExplain())
                .explain(allSkillsSaveDto.getEffect())
                .build();

        allSkillsRepository.save(allSkills);
    }
*/

    public CharacterSkillsDtoList saveSkillsPro(String name){
        List<AllSkills> characterSkillsList
                = allSkillsRepository.findByCharacterName(name).stream().sorted(Comparator.comparing(AllSkills::getSkillType)).collect(Collectors.toList());
        CharacterSkillsDtoList characterSkillsDtoList;
        if(characterSkillsList.isEmpty()){
            List<CharacterSkillsDto> dto = new ArrayList<>();
            List<SkillEffectDto> skillEffectDtoList= new ArrayList<>();
            dto.add(new CharacterSkillsDto(name , SkillType.pas.getType(),"","","",skillEffectDtoList));
            dto.add(new CharacterSkillsDto(name , SkillType.act.getType(),"","","",skillEffectDtoList));
            dto.add(new CharacterSkillsDto(name , SkillType.ult.getType(),"","","",skillEffectDtoList));
            characterSkillsDtoList = new CharacterSkillsDtoList(dto);
        } else {
            characterSkillsDtoList = new CharacterSkillsDtoList(characterSkillsList.stream().map(CharacterSkillsDto::new).collect(Collectors.toList()));
        }
        return characterSkillsDtoList;
    }

    public SkillEffectDtoList skillEffects(){
        return new SkillEffectDtoList(skillEffectsRepository.findAll().stream().map(SkillEffectDto::new).collect(Collectors.toList()));
    }

    public String saveSkillsByDto(CharacterSkillsDtoList characterSkillsDtoList){
        try{
            for(CharacterSkillsDto dto : characterSkillsDtoList.getCharacterSkillsDto()){

                AllSkills allSkills = AllSkills.builder()
                        .skillType(findTypes.findSkillTypeByName(dto.getSkillType()))
                        .skillName(dto.getSkillName())
                        .explain(dto.getExplain().replace("\r\n" , "<br>"))
                        .effect(dto.getEffect().replace("\r\n" , "<br>"))
                        .characters(characterRepository.getReferenceById(dto.getCharacterName()))
                        .build();
                allSkillsRepository.save(allSkills);
            } return "home";
        } catch (Exception e){
            System.out.println("오류가 발생했습니다 : "+e.getMessage());
            return "saveError";
        }
    }

}
