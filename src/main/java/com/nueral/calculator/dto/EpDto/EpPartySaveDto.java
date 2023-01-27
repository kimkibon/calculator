package com.nueral.calculator.dto.EpDto;

import com.nueral.calculator.entity.epParty.EpParty;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EpPartySaveDto {
    private int EpPool;
    private int epPartyIndex;
    private String characterName;
    private List<EpRecommendSaveDto> epRecommendSaveDtoList;

    public EpPartySaveDto(EpParty epParty){
        this.EpPool = epParty.getEpPool().getEpIndex();
        this.epPartyIndex = epParty.getEpPartyIndex();
        this.characterName = epParty.getCharacters().getName();
        this.epRecommendSaveDtoList = epParty.getEpRecommendList().stream().map(EpRecommendSaveDto::new).collect(Collectors.toList());
    }
}
