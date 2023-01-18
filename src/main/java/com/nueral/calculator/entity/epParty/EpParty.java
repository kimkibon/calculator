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
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ep_index", nullable = false)
    @ToString.Exclude
    private EpPool epPool;
    @Id
    private int epPartyIndex;
    private int recommended;
    private int support;
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CHARACTER_NAME", nullable = false , referencedColumnName ="CHARACTER_NAME")
    @ToString.Exclude
    private Characters characters;

    public void setEpPool(EpPool epPool) {
        this.epPool = epPool;
    }

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
