package com.nueral.calculator.dto.goodsDto;

import com.nueral.calculator.entity.friendship.GoodsCharacter;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GoodsCharacterSaveDto {
    private String characterName;
    private String goodsName;
    private boolean goodsLike;

    public GoodsCharacterSaveDto(String name){
        this.characterName = name;
    }

    public GoodsCharacterSaveDto(GoodsCharacter goodsCharacter){
        this.characterName = goodsCharacter.getCharacters().getName();
        this.goodsName = goodsCharacter.getAllGoods().getName();
        this.goodsLike = goodsCharacter.isGoodsLike();
    }
}
