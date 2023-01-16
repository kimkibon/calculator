package com.nueral.calculator.entity.epParty;

import com.nueral.calculator.entity.Characters;
import com.nueral.calculator.entity.DefaultEntity;
import com.nueral.calculator.entity.epParty.id.EpPartyId;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@IdClass(EpPartyId.class)
public class EpParty extends DefaultEntity {
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "ep_index", nullable = false)
    private EpPool epPool;
    @Id
    private int epPartyIndex;
    private int recommended;
    private int support;
    @ManyToOne
    @JoinColumn(name = "character_name")
    private Characters characters;

    @Builder
    public EpParty(EpPool epPool, int epPartyIndex ,
                   int recommended , int support , Characters characters){
        this.epPool = epPool;
        this.epPartyIndex = epPartyIndex;
        this.recommended = recommended;
        this.support = support;
        this.characters = characters;
    }
}
