package com.nueral.calculator.entity.epParty;

import com.nueral.calculator.entity.DefaultEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
@SequenceGenerator(name = "EP_RECOMMEND_IDX_GENERATOR" , sequenceName = "EP_RECOMMEND_SEQ", allocationSize = 1) // 시퀀스 생성
public class EpRecommend extends DefaultEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "EP_RECOMMEND_IDX_GENERATOR")
    private int epRecommendIndex;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumns({
        @JoinColumn(name = "EP_PARTY_INDEX", nullable = false , referencedColumnName ="EP_PARTY_INDEX"),
        @JoinColumn(name = "ep_index", nullable = false, referencedColumnName ="ep_index")
    })
    @ToString.Exclude
    private EpParty epParty;
}
