package com.nueral.calculator.entity.epParty;

import com.nueral.calculator.entity.DefaultEntity;
import com.nueral.calculator.entity.character.Characters;
import com.nueral.calculator.entity.epParty.id.EpPartyId;
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
@IdClass(EpPartyId.class)
@SequenceGenerator(name = "EP_PARTY_IDX_GENERATOR" , sequenceName = "EP_PARTY_SEQ", allocationSize = 1) // 시퀀스 생성
public class EpParty extends DefaultEntity {
    @Id
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ep_index", nullable = false)
    @ToString.Exclude
    private EpPool epPool;
    @Id //PRIMARY_KEY
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "EP_PARTY_IDX_GENERATOR"
    ) // 위에서 정의한 SEQ 를 사용하겠다.
    @Column(name = "EP_PARTY_INDEX")
    private int epPartyIndex;
    @OneToMany(mappedBy = "epParty" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<EpMember> epMemberList;

    @Builder
    public EpParty(EpPool epPool, int epPartyIndex, List<EpMember> epMemberList){
        this.epPool = epPool;
        this.epPartyIndex = epPartyIndex;
        this.epMemberList = epMemberList;
    }
}
