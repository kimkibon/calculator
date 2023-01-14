package com.nueral.calculator.dto.goodsDto;

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
}
