package com.nueral.calculator.entity.friendship;

import com.nueral.calculator.entity.DefaultEntity;
import com.nueral.calculator.entity.friendship.id.GoodsStatusLevelId;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
@IdClass(GoodsStatusLevelId.class)
public class GoodsStatusLevel extends DefaultEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GOODS_STATUS_NAME", nullable = false , referencedColumnName ="GOODS_STATUS_NAME")
    @ToString.Exclude
    private GoodsStatus goodsStatus;
    @Id
    private int statusLevel;
    private double status;

    @Builder
    public GoodsStatusLevel(GoodsStatus goodsStatus , int statusLevel , double status){
        this.goodsStatus = goodsStatus;
        this.statusLevel = statusLevel;
        this.status = status;
    }

}
