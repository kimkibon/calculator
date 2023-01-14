package com.nueral.calculator.entity.images;

import com.nueral.calculator.entity.Characters;
import com.nueral.calculator.entity.images.id.SkinsId;
import com.nueral.calculator.entity.DefaultEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@DynamicUpdate
@DynamicInsert
@IdClass(SkinsId.class)
public class Skins extends DefaultEntity {
    @Id
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CHARACTER_NAME", nullable = false , referencedColumnName ="CHARACTER_NAME")
    @ToString.Exclude
    private Characters characters;
    private String stdName;
    @Id
    private String type;

    @Builder
    public Skins(Characters characters, String stdName, String type){
        this.characters = characters;
        this.stdName = stdName;
        this.type = type;
    }
}
