package com.nueral.calculator.entity.friendship.id;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class GoodsStatusLevelId implements Serializable {
    private String goodsStatus;
    private int statusLevel;

}
