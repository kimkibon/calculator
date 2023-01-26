package com.nueral.calculator.dto.EpDto;

import com.nueral.calculator.entity.epParty.EpParty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EpPartySaveDto {
    private int EpPool;
    private int epPartyIndex;
    private String characterName;

    public EpPartySaveDto(EpParty epParty){
        this.EpPool = epParty.getEpPool().getEpIndex();
        this.epPartyIndex = epParty.getEpPartyIndex();
        this.characterName = epParty.getCharacters().getName();
    }
}
