package com.nueral.calculator.dto.goodsDto;

import com.nueral.calculator.entity.friendship.GoodsCharacter;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GoodsCharacterDto {
    private String goodsName;
    private int goodsLevel;

    public GoodsCharacterDto(GoodsCharacter goodsCharacter){
        this.goodsName = goodsCharacter.getAllGoods().getName();
        this.goodsLevel = goodsCharacter.getAllGoods().getGoodsLevel();
    }
}
