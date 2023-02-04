package com.nueral.calculator.service.epService;

import com.nueral.calculator.dto.EpDto.EpMemberDto;
import com.nueral.calculator.dto.EpDto.EpPartyDto;
import com.nueral.calculator.dto.EpDto.EpPoolDto;
import com.nueral.calculator.dto.character.AllCharactersDto;
import com.nueral.calculator.entity.epParty.EpMember;
import com.nueral.calculator.entity.epParty.EpParty;
import com.nueral.calculator.entity.epParty.EpPool;
import com.nueral.calculator.entity.epParty.id.EpPartyId;
import com.nueral.calculator.repository.CharacterRepository;
import com.nueral.calculator.repository.epParty.EpMemberRepository;
import com.nueral.calculator.repository.epParty.EpPartyRepository;
import com.nueral.calculator.repository.epParty.EpPoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class EpService {
    @Autowired
    private EpPartyRepository epPartyRepository;
    @Autowired
    private EpPoolRepository epPoolRepository;
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private EpMemberRepository epMemberRepository;


    public EpPoolDto saveEpPoolPro(int index) {
        EpPoolDto epPoolDto;
        if(index == 0) {
            int count = (int) epPoolRepository.count();
            EpPool preEpPool = epPoolRepository.findById(count)
                    .orElse(EpPool.builder()
                            .startDate(LocalDate.now())
                            .endDate(LocalDate.now())
                            .build());
            LocalDate endDate = preEpPool.getEndDate();
            List<EpParty> epPartyList = new ArrayList<>();
            List<EpMember> epMemberList = new ArrayList<>();
            EpPool epPool = EpPool.builder().startDate(endDate).endDate(endDate.plusWeeks(2)).epPartyList(epPartyList).epIndex(count+1).build();
            epPartyList.add(EpParty.builder().epPool(epPool).epPartyIndex(0).epMemberList(epMemberList).build());
            epPoolDto = new EpPoolDto(epPool);
        } else {
            EpPool epPool = epPoolRepository.findById(index).get();
            epPoolDto = new EpPoolDto(epPool);
            if(epPool.getEpPartyList().isEmpty()){
                List<EpParty> epPartyList = new ArrayList<>();
                List<EpMember> epMemberList = new ArrayList<>();
                epPartyList.add(EpParty.builder().epPartyIndex(0).epMemberList(epMemberList).build());
                epPoolDto.setEpPartyDtoList(epPartyList.stream().map(EpPartyDto::new).collect(Collectors.toList()));
            }
        }
        return epPoolDto;
    }

    public String saveEpPool(EpPoolDto epPoolDto){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            EpPool epPool = EpPool.builder()
                    .epIndex(epPoolDto.getEpPoolIndex())
                    .startDate(LocalDate.parse(epPoolDto.getStartDate(),formatter))
                    .endDate(LocalDate.parse(epPoolDto.getEndDate(),formatter))
                    .fstStage(epPoolDto.getFstStage())
                    .sndStage(epPoolDto.getSndStage())
                    .thdStage(epPoolDto.getThdStage())
                    .bossName(epPoolDto.getBossName())
                    .build();
            epPoolRepository.save(epPool);
            for(EpPartyDto dto : epPoolDto.getEpPartyDtoList()){
                EpParty epParty = EpParty.builder()
                        .epPool(epPool)
                        .epPartyIndex(dto.getEpPartyIndex())
                        .build();
                epPartyRepository.save(epParty);
                for(EpMemberDto member : dto.getEpMemberDtoList().stream().filter(distinctByKey(EpMemberDto::getCharacterName)).collect(Collectors.toList())){
                    if(!member.getCharacterName().equals("")){
                        EpMember epMember = EpMember.builder()
                                .characters(characterRepository.getReferenceById(member.getCharacterName()))
                                .epMemberIndex(member.getEpMemberIndex())
                                .support(member.getSupport())
                                .epParty(epParty)
                                .reinforce(member.getReinforce())
                                .build();
                        epMemberRepository.save(epMember);
                    }
                }
            }
            return "redirect:/home";
        } catch (Exception e){
            System.out.println("오류가 발생했습니다 : "+e.getMessage());
            return "redirect:/saveError";
        }
    }

    public EpPartyDto saveEpPartyPro(int poolIndex , int partyIndex){
        EpParty epParty;
        if(partyIndex == 0){
            int count = (int)epPartyRepository.countByEpPool_EpIndex(poolIndex);
            List<EpMember> epMemberList = new ArrayList<>();
            epParty = EpParty.builder().epPool(epPoolRepository.getReferenceById(poolIndex)).epPartyIndex(count).epMemberList(epMemberList).build();
        } else {
            EpPartyId epPartyId = new EpPartyId(poolIndex , partyIndex);
            epParty = epPartyRepository.findById(epPartyId).get();
        }
        return new EpPartyDto(epParty);
    }

    public String saveEpParty(EpPartyDto epPartyDto){
        try {
            EpParty epParty = EpParty.builder()
                    .epPool(epPoolRepository.findById(epPartyDto.getEpPoolIndex()).get())
                    .epPartyIndex(epPartyDto.getEpPartyIndex())
                    .build();
            epPartyRepository.save(epParty);
            for(EpMemberDto member : epPartyDto.getEpMemberDtoList().stream().filter(distinctByKey(EpMemberDto::getCharacterName)).collect(Collectors.toList())){
                if(!member.getCharacterName().equals("")){
                    EpMember epMember = EpMember.builder()
                            .characters(characterRepository.getReferenceById(member.getCharacterName()))
                            .epMemberIndex(member.getEpMemberIndex())
                            .support(member.getSupport())
                            .epParty(epParty)
                            .reinforce(member.getReinforce())
                            .build();
                    epMemberRepository.save(epMember);
                }
            }
            return "redirect:/home";
        } catch (Exception e){
            System.out.println("오류가 발생했습니다 : "+e.getMessage());
            return "redirect:/saveError";
        }
    }

    public List<AllCharactersDto> epPoolCharacter(int poolIndex){
        List<AllCharactersDto> AllCharactersDto;
        EpPartyId epPartyId = new EpPartyId(poolIndex , 0);
        if(epPartyRepository.findById(epPartyId).isPresent()) {
            AllCharactersDto = epPartyRepository.findById(epPartyId).get().getEpMemberList().stream().map(member -> new AllCharactersDto(member.getCharacters())).collect(Collectors.toList());
        } else {
            AllCharactersDto = characterRepository.findAll().stream().map(AllCharactersDto::new).collect(Collectors.toList());
        }
        return AllCharactersDto;
    }
    public static <T> Predicate<T> distinctByKey(Function<? super T,Object> keyExtractor) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    public List<EpPoolDto> EpPoolDtoList() {
        return epPoolRepository.findAll().stream().sorted(Comparator.comparingInt(EpPool::getEpIndex).reversed()).map(EpPoolDto::new).collect(Collectors.toList());
    }
}
