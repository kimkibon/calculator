package com.nueral.calculator.entity.character.id;

import lombok.*;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class RecommendPartyId implements Serializable {
    private String characters;
    private int partyIndex;
}
