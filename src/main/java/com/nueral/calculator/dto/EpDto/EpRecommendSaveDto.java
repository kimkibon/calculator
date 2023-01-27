package com.nueral.calculator.dto.EpDto;

import com.nueral.calculator.entity.epParty.EpRecommend;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EpRecommendSaveDto {
    private int epPartyIndex;
    private int epRecommendIndex;

    public EpRecommendSaveDto(EpRecommend epRecommend){
        this.epPartyIndex = epRecommend.getEpParty().getEpPartyIndex();
        this.epRecommendIndex = epRecommend.getEpRecommendIndex();
    }
}
