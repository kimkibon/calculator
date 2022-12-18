package com.nueral.calculator.entity.friendship.id;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class GoodsStatusCharacterId implements Serializable {

    private String characters;
    private String goodsStatus;
}
