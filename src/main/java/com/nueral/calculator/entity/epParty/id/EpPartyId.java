package com.nueral.calculator.entity.epParty.id;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class EpPartyId implements Serializable {
    private int epPool;
    private int epPartyIndex;
}
