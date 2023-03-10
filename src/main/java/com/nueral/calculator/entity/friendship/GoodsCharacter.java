package com.nueral.calculator.entity.friendship;

import com.nueral.calculator.entity.character.Characters;
import com.nueral.calculator.entity.DefaultEntity;
import com.nueral.calculator.entity.friendship.id.GoodsCharacterId;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
@IdClass(GoodsCharacterId.class)
public class GoodsCharacter extends DefaultEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CHARACTER_NAME", nullable = false , referencedColumnName ="CHARACTER_NAME")
    @ToString.Exclude
    private Characters characters;

    @Id
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "GOODS_NAME", nullable = false , referencedColumnName ="GOODS_NAME")
    @ToString.Exclude
    private AllGoods allGoods;

    @Builder
    public GoodsCharacter(Characters characters, AllGoods allGoods){
        this.characters = characters;
        this.allGoods = allGoods;
    }


}
