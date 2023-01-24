package com.nueral.calculator.service.skill;

import com.nueral.calculator.dto.skillsDto.CharacterSkillsDto;
import com.nueral.calculator.dto.skillsDto.CharacterSkillsDtoList;
import com.nueral.calculator.dto.skillsDto.SkillEffectDto;
import com.nueral.calculator.entity.skill.AllSkills;
import com.nueral.calculator.entity.skill.SkillEffects;
import com.nueral.calculator.entity.skill.SkillEffectsMap;
import com.nueral.calculator.repository.CharacterRepository;
import com.nueral.calculator.repository.skill.AllSkillsRepository;
import com.nueral.calculator.repository.skill.SkillEffectsMapRepository;
import com.nueral.calculator.repository.skill.SkillEffectsRepository;
import com.nueral.calculator.types.SkillType;
import com.nueral.calculator.utils.FindTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private SkillEffectsMapRepository skillEffectsMapRepository;

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

    @Transactional
    public String deleteSkillEffect(int index){
        try {
            skillEffectsRepository.deleteByEffectIndex(index);
            return "home";
        } catch (Exception e){
            System.out.println("오류가 발생했습니다 : "+e.getMessage());
            return "saveError";
        }
    }

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

    public List<SkillEffectDto> skillEffects(){
        return skillEffectsRepository.findAll().stream().map(SkillEffectDto::new).collect(Collectors.toList());
    }

    public String updateSkillEffects(SkillEffectDto skillEffectDto){
        try {
            SkillEffects skillEffects = SkillEffects.builder()
                    .effectsName(skillEffectDto.getEffectsName())
                    .effectsExplain(skillEffectDto.getEffects().replace("\r\n" , "<br>"))
                    .effectIndex(skillEffectDto.getEffectIndex())
                    .build();
            skillEffectsRepository.save(skillEffects);
            return "home";
        } catch (Exception e){
            System.out.println("오류가 발생했습니다 : "+e.getMessage());
            return "saveError";
        }
    }

    @Transactional
    public String saveSkillsByDto(CharacterSkillsDtoList characterSkillsDtoList){
        try{
            for(CharacterSkillsDto dto : characterSkillsDtoList.getCharacterSkillsDto()){
                AllSkills allSkills = AllSkills.builder()
                        .skillType(findTypes.findSkillTypeByName(dto.getSkillType()))
                        .skillName(dto.getSkillName())
                        .explain(dto.getExplain().replace("\r\n" , "<br>"))
                        .effect(dto.getEffect().replace("\r\n" , "<br>"))
                        .characters(characterRepository.findById(dto.getCharacterName()).get())
                        .build();
                allSkillsRepository.save(allSkills);
                skillEffectsMapRepository.deleteByAllSkills(allSkills);
                skillEffectsMapRepository.flush();
                allSkills.getSkillEffectsMapList().clear();
                    for (SkillEffectDto skillEffectDto : dto.getSkillEffectDtoList()) {
                        System.out.println(skillEffectDto.getEffectIndex());
                        if(skillEffectDto.getEffectIndex() != 0){
                            SkillEffects skillEffects = skillEffectsRepository.findById(skillEffectDto.getEffectIndex()).get();
                            SkillEffectsMap skillEffectsMap = new SkillEffectsMap(allSkills , skillEffects);
                            skillEffectsMapRepository.save(skillEffectsMap);
                        }
                }
            } return "home";
        } catch (Exception e){
            System.out.println("오류가 발생했습니다 : "+e.getMessage());
            return "saveError";
        }
    }

}
