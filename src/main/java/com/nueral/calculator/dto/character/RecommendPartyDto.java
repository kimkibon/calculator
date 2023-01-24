package com.nueral.calculator.dto.character;

import com.nueral.calculator.entity.character.RecommendParty;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RecommendPartyDto {
    private String partyExplain;
    private String characterName;
    private int partyIndex;
    private List<RecommendPartyMemberDto> memberDtoList;

    public RecommendPartyDto(RecommendParty recommendParty){
        this.partyIndex = recommendParty.getPartyIndex();
        this.partyExplain = recommendParty.getPartyExplain().replace("<br>" , "\r\n");
        this.characterName = recommendParty.getCharacters().getName();
        this.memberDtoList =
                recommendParty.getRecommendPartyMemberList()
                        .stream().map(RecommendPartyMemberDto::new).collect(Collectors.toList());
    }

}
