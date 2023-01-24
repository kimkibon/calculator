package com.nueral.calculator.entity.character;

import com.nueral.calculator.entity.DefaultEntity;
import com.nueral.calculator.entity.character.id.RecommendPartyMemberId;
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
@IdClass(RecommendPartyMemberId.class)
@SequenceGenerator(name = "MEMBER_IDX_GENERATOR" , sequenceName = "MEMBER_SEQ", allocationSize = 1) // 시퀀스 생성
public class RecommendPartyMember extends DefaultEntity {
    @Id
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumns({
            @JoinColumn(name = "CHARACTER_NAME", referencedColumnName = "CHARACTER_NAME", nullable = false),
            @JoinColumn(name = "PARTY_INDEX", nullable = false , referencedColumnName ="PARTY_INDEX")
    })
    @ToString.Exclude
    private RecommendParty recommendParty;
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_IDX_GENERATOR")
    private int memberIndex;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PARTY_MEMBER", referencedColumnName = "CHARACTER_NAME", nullable = false)
    @ToString.Exclude
    private Characters partyMember;

    @Builder
    public RecommendPartyMember(RecommendParty recommendParty , Characters partyMember,int memberIndex){
        this.recommendParty = recommendParty;
        this.partyMember = partyMember;
        this.memberIndex = memberIndex;
    }
}
