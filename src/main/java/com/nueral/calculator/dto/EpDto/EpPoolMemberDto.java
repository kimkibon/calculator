package com.nueral.calculator.dto.EpDto;

import com.nueral.calculator.entity.epParty.EpMember;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EpPoolMemberDto {
    String characterName;
    String roleType;
    String profile;
    int reinforce;

    public EpPoolMemberDto(EpMember epMember){
        this.characterName = epMember.getCharacters().getName();
        this.profile = epMember.getCharacters().getProfile();
        this.reinforce = epMember.getReinforce();
        this.roleType = epMember.getCharacters().getRoleType().getType();
    }
}
