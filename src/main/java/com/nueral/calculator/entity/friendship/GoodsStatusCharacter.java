package com.nueral.calculator.entity.friendship;

import com.nueral.calculator.entity.Characters;
import com.nueral.calculator.entity.DefaultEntity;
import com.nueral.calculator.entity.friendship.id.GoodsStatusCharacterId;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
@IdClass(GoodsStatusCharacterId.class)
public class GoodsStatusCharacter extends DefaultEntity {


    @Id
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CHARACTER_NAME", nullable = false , referencedColumnName ="CHARACTER_NAME")
    @ToString.Exclude
    private Characters characters;
    @Id
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "GOODS_STATUS_NAME", nullable = false , referencedColumnName ="GOODS_STATUS_NAME")
    @ToString.Exclude
    private GoodsStatus goodsStatus;
    private int statusLevel;

    public void setCharacters(Characters characters) {
        this.characters = characters;
    }

    @Builder
    public GoodsStatusCharacter(Characters characters, GoodsStatus goodsStatus , int statusLevel){
        this.characters = characters;
        this.goodsStatus = goodsStatus;
        this.statusLevel = statusLevel;
    }
}
