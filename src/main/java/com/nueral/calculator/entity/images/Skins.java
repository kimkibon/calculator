package com.nueral.calculator.entity.images;

import com.nueral.calculator.entity.Characters;
import com.nueral.calculator.entity.DefaultEntity;
import com.nueral.calculator.entity.images.id.SkinsId;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
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
    public Skins(String stdName, String type){
        this.stdName = stdName;
        this.type = type;
    }
}
