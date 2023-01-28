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
public class EpPartyDto {
    private int epPartyIndex;
    private List<EpMemberDto> epMemberDtoList;

    public EpPartyDto(EpParty epParty){
        this.epPartyIndex = epParty.getEpPartyIndex();
        this.epMemberDtoList = epParty.getEpMemberList().stream().map(EpMemberDto::new).collect(Collectors.toList());
    }
}
