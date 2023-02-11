package com.nueral.calculator.service.characterService;

import com.nueral.calculator.dto.character.*;
import com.nueral.calculator.entity.character.Characters;
import com.nueral.calculator.entity.character.RecommendParty;
import com.nueral.calculator.entity.character.RecommendPartyMember;
import com.nueral.calculator.repository.character.RecommendPartyMemberRepository;
import com.nueral.calculator.repository.character.RecommendPartyRepository;
import com.nueral.calculator.mapping.CharacterName;
import com.nueral.calculator.repository.CharacterRepository;
import com.nueral.calculator.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService {
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private FileUtil fileUtil;
    @Autowired
    private RecommendPartyRepository recommendPartyRepository;
    @Autowired
    private RecommendPartyMemberRepository recommendPartyMemberRepository;


    public CharacterInfoDto findCharacterInfo(String name){

        return new CharacterInfoDto(characterRepository.findByName(name).orElse(new Characters()));
    }

    public List<String> findAllCharacterName(){
        return characterRepository.findAllBy().stream().map(CharacterName::getName).collect(Collectors.toList());
    }

    public List<AllCharactersDto> findAllCharacterInfo(){

        return characterRepository.findAll(Sort.by(Sort.Direction.DESC, "defaultStar"))
                .stream().sorted(Comparator.comparing(Characters::getRoleType)).map(AllCharactersDto::new)
                .collect(Collectors.toList());
    }

    public CharacterSaveDto beforeSave(String name){
        Characters characters = characterRepository.findByName(name).orElse(new Characters());
        return new CharacterSaveDto(characters);
    }
    @Transactional
    public String saveByDto(CharacterSaveDto characterSaveDto , MultipartFile file) throws Exception {
        System.out.println(!file.isEmpty());
        if(!file.isEmpty()) {
            String insertFile = fileUtil.saveProfile(characterSaveDto.getCharacterName(), "profile", file);
            characterSaveDto.setProfile(insertFile);
        }
            Characters characters = new Characters(characterSaveDto);
        try {
            characterRepository.save(characters);
            return "redirect:/home";
        } catch (Exception e){
            return "redirect:/saveError";
        }
    }
    public RecommendPartyDtoList saveRecommendPartyPro(String name){
        List<RecommendParty> parties = recommendPartyRepository.findByCharacters_Name(name);
        RecommendPartyDtoList recommendPartyDtoList;
        if(parties.isEmpty()){
            RecommendPartyDto partyDto = new RecommendPartyDto();
            partyDto.setCharacterName(name);
            partyDto.setMemberDtoList(new ArrayList<>());
            List<RecommendPartyDto> partyDtoList = new ArrayList<>();
            partyDtoList.add(partyDto);
            recommendPartyDtoList = new RecommendPartyDtoList(partyDtoList);
        } else {
            recommendPartyDtoList = new RecommendPartyDtoList(parties.stream().map(RecommendPartyDto::new).collect(Collectors.toList()));
        }
        return recommendPartyDtoList;
    }
    @Transactional
    public String saveRecommendParty(String name , RecommendPartyDtoList recommendPartyDtoList){
        try{recommendPartyRepository.deleteByCharacters(characterRepository.findByName(name).get());
            recommendPartyRepository.flush();
            for(RecommendPartyDto partyDto : recommendPartyDtoList.getRecommendPartyDtoList()){
                RecommendParty recommendParty = RecommendParty.builder()
                        .characters(characterRepository.findByName(partyDto.getCharacterName()).get())
                        .partyExplain(partyDto.getPartyExplain().replace("\r\n" , "<br>"))
                        .partyIndex(partyDto.getPartyIndex())
                        .build();
                recommendPartyRepository.saveAndFlush(recommendParty);
                for(RecommendPartyMemberDto member : partyDto.getMemberDtoList()){
                    if(!member.getCharacterName().equals("")){
                        RecommendPartyMember recommendPartyMember = RecommendPartyMember.builder()
                                .recommendParty(recommendParty)
                                .memberIndex(member.getMemberIndex())
                                .partyMember(characterRepository.getReferenceById(member.getCharacterName()))
                                .build();
                        recommendPartyMemberRepository.save(recommendPartyMember);
                    }

                }
            }
            return "redirect:/home";
        } catch (Exception e){
            System.out.println("오류가 발생했습니다 : "+e.getMessage());
            return "redirect:/saveError";
        }
    }

    public void deleteCharacter(String name){
        characterRepository.deleteById(name);
    }

/**
    public Characters save(
            String name, DealType dealType , RoleType roleType,
            AreaType areaType ,CompanyType companyType , int defaultStar){

        Characters characters = Characters.builder()
                .name(name)
                .dealType(dealType)
                .roleType(roleType)
                .companyType(companyType)
                .areaType(areaType)
                .defaultStar(defaultStar)
                .profile("/image/character/profile/"+name+".png")
                .build();

        characterRepository.saveAndFlush(characters);
        return characters;
    }
*/
}
