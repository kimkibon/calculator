package com.nueral.calculator.dto.goodsDto;

import com.nueral.calculator.entity.friendship.GoodsStatusCharacter;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GoodsStatusCharacterSaveDto {
    private String characterName;
    private String statusName;
    private int statusLevel;

    public GoodsStatusCharacterSaveDto(GoodsStatusCharacter goodsStatusCharacter){
        this.characterName = goodsStatusCharacter.getCharacters().getName();
        this.statusName = goodsStatusCharacter.getGoodsStatus().getName();
        this.statusLevel = goodsStatusCharacter.getStatusLevel();
    }
}
