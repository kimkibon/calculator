package com.nueral.calculator.dto.EpDto;

import com.nueral.calculator.entity.epParty.EpMember;
import com.nueral.calculator.entity.epParty.EpParty;
import lombok.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EpPartyDto {
    private int epPartyIndex;
    private int epPoolIndex;
    private List<EpMemberDto> epMemberDtoList;

    public EpPartyDto(EpParty epParty){
        this.epPoolIndex = epParty.getEpPool().getEpIndex();
        this.epPartyIndex = epParty.getEpPartyIndex();
        this.epMemberDtoList = epParty.getEpMemberList().stream().sorted(Comparator.comparingInt(EpMember::getSupport).thenComparingInt(EpMember::getReinforce)).map(EpMemberDto::new).collect(Collectors.toList());
    }
}
