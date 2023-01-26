package com.nueral.calculator.entity.epParty;

import com.nueral.calculator.entity.character.Characters;
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
@SequenceGenerator(name = "EPPARTY_IDX_GENERATOR" , sequenceName = "EPPARTY_SEQ", allocationSize = 1) // 시퀀스 생성
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
            generator = "EPPARTY_IDX_GENERATOR"
    ) // 위에서 정의한 SEQ 를 사용하겠다.
    private int epPartyIndex;
    private int reinforcements;
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CHARACTER_NAME", nullable = false , referencedColumnName ="CHARACTER_NAME")
    @ToString.Exclude
    private Characters characters;

    @Builder
    public EpParty(EpPool epPool, int epPartyIndex , int reinforcements , Characters characters){
        this.epPool = epPool;
        this.epPartyIndex = epPartyIndex;
        this.reinforcements = reinforcements;
        this.characters = characters;
    }
}
