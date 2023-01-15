package com.nueral.calculator.dto.goodsDto;

import com.nueral.calculator.entity.friendship.GoodsStatusCharacter;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GoodsStatusCharacterDto {
    private String statusName;
    private String status;
    private int statusLevel;


    public GoodsStatusCharacterDto(GoodsStatusCharacter goodsStatusCharacter){
        this.statusName = goodsStatusCharacter.getGoodsStatus().getName();
        this.status = goodsStatusCharacter.getGoodsStatus().getStatus();
        this.statusLevel = goodsStatusCharacter.getStatusLevel();
    }
}
