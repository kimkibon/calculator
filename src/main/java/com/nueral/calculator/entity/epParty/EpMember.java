package com.nueral.calculator.entity.epParty;

import com.nueral.calculator.entity.DefaultEntity;
import com.nueral.calculator.entity.character.Characters;
import com.nueral.calculator.entity.epParty.id.EpMemberId;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
@IdClass(EpMemberId.class)
public class EpMember extends DefaultEntity {
    @Id
    private int epMemberIndex;

    @Id
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumns({
        @JoinColumn(name = "EP_PARTY_INDEX", nullable = false , referencedColumnName ="EP_PARTY_INDEX"),
        @JoinColumn(name = "EP_INDEX", nullable = false, referencedColumnName ="EP_INDEX")
    })
    @ToString.Exclude
    private EpParty epParty;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CHARACTER_NAME", nullable = false , referencedColumnName ="CHARACTER_NAME")
    @ToString.Exclude
    private Characters characters;

    private int support;
    private int reinforce;

    @Builder
    public EpMember(int epMemberIndex, EpParty epParty, Characters characters, int support , int reinforce){
        this.epMemberIndex = epMemberIndex;
        this.epParty = epParty;
        this.characters = characters;
        this.support = support;
        this.reinforce = reinforce;
    }
}
