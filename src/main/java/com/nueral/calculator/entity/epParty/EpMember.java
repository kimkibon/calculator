package com.nueral.calculator.entity.epParty;

import com.nueral.calculator.entity.DefaultEntity;
import com.nueral.calculator.entity.character.Characters;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
@SequenceGenerator(name = "EP_MEMBER_IDX_GENERATOR" , sequenceName = "EP_MEMBER_SEQ", allocationSize = 1) // 시퀀스 생성
public class EpMember extends DefaultEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "EP_MEMBER_IDX_GENERATOR")
    private int epMemberIndex;

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
