package com.nueral.calculator.dto.character;

import com.nueral.calculator.entity.character.RecommendPartyMember;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RecommendPartyMemberDto {
    private int memberIndex;
    private String characterName;
    private String roleType;
    private int defaultStar;
    private String profile;

    public RecommendPartyMemberDto(RecommendPartyMember recommendPartyMember){
        this.memberIndex = recommendPartyMember.getMemberIndex();
        this.characterName = recommendPartyMember.getPartyMember().getName();
        this.defaultStar = recommendPartyMember.getPartyMember().getDefaultStar();
        this.profile = recommendPartyMember.getPartyMember().getProfile();
        this.roleType = recommendPartyMember.getPartyMember().getRoleType().getType();
    }
}
