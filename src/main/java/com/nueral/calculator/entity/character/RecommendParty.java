package com.nueral.calculator.entity.character;

import com.nueral.calculator.entity.character.id.RecommendPartyId;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@IdClass(RecommendPartyId.class)
public class RecommendParty {
    @Id
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CHARACTER_NAME", nullable = false , referencedColumnName ="CHARACTER_NAME")
    @ToString.Exclude
    private Characters characters;
    @Id
    @Column(name = "PARTY_INDEX")
    private int partyIndex;
    private String partyExplain;
    @OneToMany(mappedBy = "recommendParty" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<RecommendPartyMember> recommendPartyMemberList;

    @Builder
    public RecommendParty(Characters characters , int partyIndex , String partyExplain){
        this.characters = characters;
        this.partyIndex = partyIndex;
        this.partyExplain = partyExplain;
    }


}
