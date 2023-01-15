package com.nueral.calculator.dto.goodsDto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GoodsStatusCharacterSaveDtoList {
    List<GoodsStatusCharacterSaveDto> goodsStatusCharacterDto;
}
