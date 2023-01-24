package com.nueral.calculator.entity.character.id;

import lombok.*;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class RecommendPartyMemberId implements Serializable {
    private RecommendPartyId recommendParty;
    private int memberIndex;
}
