package com.nueral.calculator.entity.friendship;

import com.nueral.calculator.entity.DefaultEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class AllGoods extends DefaultEntity {
    @Id
    @Column(name = "GOODS_NAME")
    private String name;
    private int goodsLevel;
    private int likeExp;
    private int hateExp;
    private int normalExp;


    @Builder
    public AllGoods(
            int goodsLevel , String name , int likeExp,
            int hateExp , int normalExp
    ){
        this.goodsLevel = goodsLevel;
        this.name = name;
        this.hateExp = hateExp;
        this.normalExp = normalExp;
        this.likeExp = likeExp;
    }
}
