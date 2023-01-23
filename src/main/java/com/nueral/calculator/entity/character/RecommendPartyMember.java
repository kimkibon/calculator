package com.nueral.calculator.entity.character;

import com.nueral.calculator.entity.character.id.RecommendPartyMemberId;
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
public class RecommendPartyMember {
    @Id
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumns({
            @JoinColumn(name = "CHARACTER_NAME", referencedColumnName = "CHARACTER_NAME", nullable = false),
            @JoinColumn(name = "PARTY_INDEX", nullable = false , referencedColumnName ="PARTY_INDEX")
    })
    private RecommendParty recommendParty;
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_IDX_GENERATOR")
    private int memberIndex;
}
