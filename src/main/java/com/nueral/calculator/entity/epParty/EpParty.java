package com.nueral.calculator.entity.epParty;

import com.nueral.calculator.entity.DefaultEntity;
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
public class EpParty extends DefaultEntity {
    @Id
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ep_index", nullable = false)
    @ToString.Exclude
    private EpPool epPool;
    @Id //PRIMARY_KEY
    @Column(name = "EP_PARTY_INDEX")
    private int epPartyIndex;

    @OneToMany(mappedBy = "epParty" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<EpMember> epMemberList;

    @Builder
    public EpParty(EpPool epPool, int epPartyIndex){
        this.epPool = epPool;
        this.epPartyIndex = epPartyIndex;
    }
}
