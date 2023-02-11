package com.nueral.calculator.dto.EpDto;

import com.nueral.calculator.entity.epParty.EpMember;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EpMemberDto {
    private int epMemberIndex;
    private String characterName;
    private String profile;
    private String roleType;
    private int defaultStar;
    private int support;
    private int reinforce;

    public EpMemberDto(EpMember epMember){
        this.characterName = epMember.getCharacters().getName();
        this.defaultStar = epMember.getCharacters().getDefaultStar();
        this.support = epMember.getSupport();
        this.reinforce = epMember.getReinforce();
        this.profile = epMember.getCharacters().getProfile();
        this.epMemberIndex = epMember.getEpMemberIndex();
        this.roleType = epMember.getCharacters().getRoleType().getType();
    }

}
