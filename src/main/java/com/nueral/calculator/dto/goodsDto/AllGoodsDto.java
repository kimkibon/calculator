package com.nueral.calculator.dto.goodsDto;

import com.nueral.calculator.entity.friendship.AllGoods;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AllGoodsDto {
    private String goodsName;
    private int GoodsLevel;

    public AllGoodsDto(AllGoods allGoods){
        this.goodsName = allGoods.getName();
        this.GoodsLevel = allGoods.getGoodsLevel();
    }
}
