package com.nueral.calculator.entity.epParty.id;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class EpMemberId implements Serializable {
    private EpPartyId epParty;
    private int epMemberIndex;
}
