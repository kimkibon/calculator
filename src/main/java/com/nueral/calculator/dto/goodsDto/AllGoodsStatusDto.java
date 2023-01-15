package com.nueral.calculator.dto.goodsDto;

import com.nueral.calculator.entity.friendship.GoodsStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AllGoodsStatusDto {
    private String statusName;
    private String status;

    public AllGoodsStatusDto(GoodsStatus goodsStatus){
        this.statusName = goodsStatus.getName();
        this.status = goodsStatus.getStatus();
    }
}
